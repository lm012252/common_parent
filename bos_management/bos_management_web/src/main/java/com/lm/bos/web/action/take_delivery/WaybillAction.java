package com.lm.bos.web.action.take_delivery;

import com.lm.bos.domain.take_delivery.WayBill;
import com.lm.bos.service.take_delivery.IWaybillService;
import com.lm.bos.web.action.common.CommonAction;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.io.IOException;

@Namespace("/")
@ParentPackage("struts-default")
@Controller
@Scope("prototype")
public class WaybillAction extends CommonAction<WayBill> {

    @Resource
    private IWaybillService waybillService;


    @Action(value = "waybillAction_save")
    public String save() throws IOException {
        String rs = "1";
        try {
            waybillService.save(getModel());
        } catch (Exception e) {
            rs = "0";
        }
        //通过输出流写回页面
        ServletActionContext.getResponse().setContentType("text/json;charset=UTF-8");
        ServletActionContext.getResponse().getWriter().print(rs);
        return NONE;

    }
}
