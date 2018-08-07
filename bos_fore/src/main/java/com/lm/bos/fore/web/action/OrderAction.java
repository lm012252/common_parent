package com.lm.bos.fore.web.action;

import com.lm.bos.cms.service.Area;
import com.lm.bos.cms.service.Order;
import com.lm.bos.cms.service.OrderServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * 前台用户管理模块 展示层
 */
@Namespace("/")
@ParentPackage("struts-default")
@Controller
@Scope("prototype")
public class OrderAction extends ActionSupport implements ModelDriven<Order> {

    //发件人省市区
    private String sendAreaInfo;
    //收件人省市区
    private String recAreaInfo;

    private Order order;

    @Resource
    private OrderServiceImpl orderProxy;

    @Action(value = "orderAction_add",results = {@Result(name = "addSuccess",location = "/order.html",type = "redirect"),
            @Result(name = "failed",location = "/fail.html",type = "redirect")})
    public String add(){
        try {
            System.out.println("sendAreaInfo=" + sendAreaInfo);
            System.out.println("recAreaInfo=" + recAreaInfo);
            if(StringUtils.isNotBlank(sendAreaInfo)){
                String[] split = sendAreaInfo.split("/");
                Area area = new Area();
                area.setProvince(split[0]);
                area.setCity(split[1]);
                area.setDistrict(split[2]);
                order.setSendArea(area);
            }
            if(StringUtils.isNotBlank(recAreaInfo)){
                String[] split = recAreaInfo.split("/");
                Area area = new Area();
                area.setProvince(split[0]);
                area.setCity(split[1]);
                area.setDistrict(split[2]);
                order.setRecArea(area);
            }
            orderProxy.save(order);
        } catch (Exception e) {
            e.printStackTrace();
            return "failed";
        }
        return "addSuccess";
    }


    public void setRecAreaInfo(String recAreaInfo) {
        this.recAreaInfo = recAreaInfo;
    }

    public void setSendAreaInfo(String sendAreaInfo) {
        this.sendAreaInfo = sendAreaInfo;
    }

    @Override
    public Order getModel() {
        if(order==null){
            order = new Order();
        }
        return order;
    }
}
