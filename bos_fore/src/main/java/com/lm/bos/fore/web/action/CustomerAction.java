package com.lm.bos.fore.web.action;

import com.aliyuncs.exceptions.ClientException;
import com.lm.bos.crm.service.Customer;
import com.lm.bos.crm.service.CustomerServiceImpl;
import com.lm.bos.fore.utils.MailUtils;
import com.lm.bos.fore.utils.SmsUtils;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Namespace("/")
@ParentPackage("struts-default")
@Controller
@Scope("prototype")
public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

    /**
     * 消息队列
     */
    @Resource
    private JmsTemplate jmsTemplate;

    /**
     * 注入redisTemplate模板
     */
    @Resource
    private RedisTemplate<String,String> redisTemplate;

    @Resource
    private CustomerServiceImpl customerProxy;

    //模型驱动
    private Customer model;
    //手机验证码
    private String checkcode;
    //邮件激活码
    private String activeCode;

    @Action(value = "customerAction_login",results = {@Result(name = "loginSuccess",location = "/myhome.html",type = "redirect"),
                @Result(name = "failed",location = "/login.html",type = "redirect")})
    public String login(){
        String telephone = model.getTelephone();
        String password = model.getPassword();
        //验证码
        String validateCode = (String) ServletActionContext.getRequest().getSession().getAttribute("validateCode");
        if(StringUtils.isNotBlank(telephone)&&StringUtils.isNotBlank(password)&&StringUtils.isNotBlank(checkcode)
                &&validateCode.equals(checkcode)){
            Customer loginCustomer = customerProxy.login(telephone, password);
            if(loginCustomer!=null){
                return "loginSuccess";
            }
        }
        return "failed";
    }

    @Action(value = "customerAction_activeMail",results = {@Result(name = "failed",location = "/signup-fail.html",type = "redirect"),
    @Result(name="already",location = "/signup-already.html",type = "redirect"),
    @Result(name = "activeMailSuccess",location = "/signup-success.html",type = "redirect")})
    public String activeMail(){
        System.out.println("我特么的进来了，哈哈哈哈");
        String telephone = model.getTelephone();
        //判断用户电话和激活码是否为空，保存失败
        if(StringUtils.isBlank(telephone)||StringUtils.isBlank(activeCode)){
            return "failed";
        }
        //根据手机号从redis中获取激活码
        String activeCodeRedis = redisTemplate.opsForValue().get(telephone);
        System.out.println("activeCodeRedis=" + activeCodeRedis);
        //判断redis激活码是否为空或者与页面的激活码是否相等
        if(StringUtils.isBlank(activeCodeRedis)||!activeCodeRedis.equals(activeCode)){
            return "failed";
        }
        //根据电话号码查询对应的用户
        Customer customer = customerProxy.findByTelephone(telephone);
        if(customer==null){
            return "failed";
        }
        //如果已经激活，则告知重新激活
        if(customer.getType() != null &&  customer.getType() == 1){
            return "already";
        }
        try {
            //如果未激活的，则激活
            customerProxy.activeMail(telephone);
            //激活成功从redis中删除激活码
            redisTemplate.delete(telephone);
            return "activeMailSuccess";
        } catch (Exception e) {
            e.printStackTrace();
            return "failed";
        }
    }

    @Action(value = "customerAction_regist",results = {@Result(name = "registSuccess",location = "/signup-success.html",type = "redirect"),
            @Result(name="failed",location = "/signup-fail.html",type = "redirect")})
    public String regist(){
        jmsTemplate.send("sms_message", new MessageCreator(){
            @Override
            public Message createMessage(Session session) throws JMSException {
                MapMessage map = session.createMapMessage();
                map.setString("telephone", model.getTelephone());
                map.setString("content", "恭喜注册成功速运快递会员，请到邮箱激活账号！");
                return map;
            }
        });
        String phoneNum = model.getTelephone();
        //获取session域里面的验证码
        String verifyCode = (String) ServletActionContext.getRequest().getSession().getAttribute("verifyCode");
        //判断输入的验证码是否正确
        System.out.println("phoneNum=" + phoneNum + ",verifyCode=" + verifyCode + ",checkcode=" + checkcode);
        if(StringUtils.isNoneBlank(phoneNum)&&StringUtils.isNoneBlank(verifyCode)&&verifyCode.equals(checkcode)){
            //验证码正确，保存数据
            customerProxy.regist(model);
            //注册成功后，通过邮件发送36位验证码
            String activeCode = RandomStringUtils.randomNumeric(36);
            //激活码24小时后失效
            redisTemplate.opsForValue().set(model.getTelephone(),activeCode,24,TimeUnit.HOURS);
            //发送邮件内容拼接36位激活码
            String content = "欢迎注册速运快递，请点击下面连接激活账号，24小时内有效！<a href="
                    +MailUtils.activeUrl+"?telephone="+model.getTelephone()+"&activeCode="+activeCode+">激活</a>";
            MailUtils.sendMail("速运快递激活",content,model.getEmail());
            return "registSuccess";
        }else {
            return "failed";
        }
    }

    /**
     * 获取验证码
     * @return
     * @throws IOException
     */
    @Action(value = "customerAction_sendMsg")
    public String sendMsg() throws IOException {
        String state = "true";
        String phoneNums = model.getTelephone();
        String randomNumeric = RandomStringUtils.randomNumeric(6);
        ServletActionContext.getRequest().getSession().setAttribute("verifyCode",randomNumeric);
        try {
            //发送短信验证码
            SmsUtils.sendSms(phoneNums,randomNumeric);
        } catch (ClientException e) {
            state="false";
            e.printStackTrace();
        }
        ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
        ServletActionContext.getResponse().getWriter().print(state);
        return NONE;
    }

    public void setActiveCode(String activeCode) {
        this.activeCode = activeCode;
    }

    public void setCheckcode(String checkcode) {
        this.checkcode = checkcode;
    }

    @Override
    public Customer getModel() {
        if(model==null){
            model = new Customer();
        }
        return model;
    }
}
