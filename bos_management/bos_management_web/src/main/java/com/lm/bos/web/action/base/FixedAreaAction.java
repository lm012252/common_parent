package com.lm.bos.web.action.base;

import com.lm.bos.crm.service.Customer;
import com.lm.bos.crm.service.CustomerServiceImpl;
import com.lm.bos.domain.base.FixedArea;
import com.lm.bos.service.base.IFixedAreaService;
import com.lm.bos.web.action.common.CommonAction;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@Namespace("/")
@ParentPackage("struts-default")
@Controller
@Scope(value="prototype")
public class FixedAreaAction extends CommonAction<FixedArea> {

    @Resource
    private IFixedAreaService fixedAreaService;

    /**
     * 代理对象
     */
    @Resource
    private CustomerServiceImpl customerProxy;

    private List<Integer> customerIds;

    private Integer takeTimeId;
    private Integer courierId;

    @Action(value = "fixedAreaAction_associationCourierToFixedArea",results =
            {@Result(name="associationCourierToFixedAreaSuccess",location = "/pages/base/fixed_area.html",type = "redirect")})
    public String associationCourierToFixedArea(){
        fixedAreaService.associationCourierToFixedArea(getModel().getId(),courierId,takeTimeId);
        return "associationCourierToFixedAreaSuccess";
    }

    @Action(value = "fixedAreaAction_assignCustomers2FixedArea",results =
            {@Result(name = "assignCustomers2FixedAreaSuccess",location = "/pages/base/fixed_area.html",type = "redirect")})
    public String assignCustomers2FixedArea(){
        customerProxy.assignCustomers2FixedArea(getModel().getId(),customerIds);
        System.out.println("哈哈");
        return "assignCustomers2FixedAreaSuccess";
    }

    /**
     * 查询未关联定区的客户
     * @return
     */
    @Action(value = "fixedAreaAction_findByFixedAreaIdIsNull")
    public String findByFixedAreaIdIsNull() throws IOException {
        List<Customer> byFixedAreaIdIsNull = customerProxy.findByFixedAreaIdIsNull();
        this.list2Json(byFixedAreaIdIsNull);
        return NONE;
    }

    /**
     * 查询已经关联定区的客户
     * @return
     */
    @Action(value = "fixedAreaAction_findByFixedAreaId")
    public String findByFixedAreaId() throws IOException {
        List<Customer> byFixedAreaId = customerProxy.findByFixedAreaId(getModel().getId());
        this.list2Json(byFixedAreaId);
        return NONE;
    }

    @Action(value = "fixedAreaAction_pageQuery")
    public String pageQuery() throws IOException {
        Pageable pageable = new PageRequest(page-1,rows);
        Page<FixedArea> page = fixedAreaService.pageQuery(pageable);
        this.page2Json(page);
        return NONE;
    }

    @Action(value = "fixedAreaAction_save",results = {@Result(name="saveFixedAreaSuccess",location = "/pages/base/fixed_area.html",type = "redirect")})
    public String saveFixedArea(){
        fixedAreaService.save(getModel());
        return "saveFixedAreaSuccess";
    }

    public void setCourierId(Integer courierId) {
        this.courierId = courierId;
    }

    public void setTakeTimeId(Integer takeTimeId) {
        this.takeTimeId = takeTimeId;
    }

    public void setCustomerIds(List<Integer> customerIds) {
        this.customerIds = customerIds;
    }

    public void setFixedAreaService(IFixedAreaService fixedAreaService) {
        this.fixedAreaService = fixedAreaService;
    }
}
