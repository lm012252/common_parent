package com.lm.bos.web.action.system;

import com.lm.bos.domain.system.User;
import com.lm.bos.web.action.common.CommonAction;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * 用户模块展示层
 */
@Namespace("/")
@ParentPackage("struts-default")
@Controller
@Scope("prototype")
public class UserAction extends CommonAction<User> {

    //属性驱动获取验证码
    private String checkCode;

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    @Action(value = "userAction_login",results = {@Result(name = "success",location = "/index.html",type = "redirect"),
                            @Result(name="home",location = "/login.html",type = "redirect")})
    public String login(){
        //获取validate.jsp生成的图片验证码
        String sessionCheckCode = (String) ServletActionContext.getRequest().getSession().getAttribute("key");
        //判断验证码是否为空，和输入的验证码checkCode是否一致
        if(StringUtils.isNotBlank(sessionCheckCode)&&sessionCheckCode.equals(checkCode)){
            //如果一致则去登录
            Subject subject = SecurityUtils.getSubject();//当前用户对象
            UsernamePasswordToken usernamePasswordToken =
                    new UsernamePasswordToken(getModel().getUsername(), getModel().getPassword());

            try {
                subject.login(usernamePasswordToken);
                //若用户存在，则将用户存储到session域中
                User user = (User) subject.getPrincipal();//获取用户对象
                if(user==null){
                    return "home";
                }
                ServletActionContext.getRequest().getSession().setAttribute("user",user);
            } catch (AuthenticationException e) {
                e.printStackTrace();
                return "home";
            }
            return SUCCESS;
        }
        return "home";
    }
}
