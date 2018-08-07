package com.lm.bos.web.action.base;

import com.lm.bos.crm.service.Customer;
import com.lm.bos.crm.service.CustomerServiceImpl;
import com.lm.bos.domain.base.Courier;
import com.lm.bos.domain.base.Standard;
import com.lm.bos.service.base.ICourierService;
import com.lm.bos.web.action.common.CommonAction;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.persistence.criteria.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Namespace("/")
@ParentPackage("struts-default")
@Controller
@Scope("prototype")
public class CourierAction extends CommonAction<Courier> {

    @Resource
    private ICourierService courierService;
    @Resource
    private CustomerServiceImpl customerProxy;

    private String ids;

    @Action(value = "courierAction_listajax")
    public String listajax() throws IOException {
        List<Courier> list = courierService.findByDeltagIsNull();
        this.list2Json(list);
        return NONE;
    }

    /**
     * 恢复快递员，使其可使用
     * @return
     */
    @Action(value="courierAction_restore",results = {@Result(name="restoreSuccess",location = "/pages/base/courier.html",type = "redirect"),
            @Result(name="fail",location = "/pages/base/error.html",type="redirect")})
    public String restore(){
        try {
            courierService.restore(ids);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "restoreSuccess";
    }

    /**
     *删除快递员，使其失效
     * @return
     */
    @Action(value="courierAction_delete",results = {@Result(name="deleteSuccess",location = "/pages/base/courier.html",type = "redirect"),
                                                    @Result(name="fail",location = "/pages/base/error.html",type="redirect")})
    public String delete(){
        try {
            courierService.delete(ids);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "deleteSuccess";
    }

    /**
     * 修改快递员信息
     * @return
     */
    @Action(value="courierAction_edit",results = {@Result(name="editCourierSuccess",location = "/pages/base/courier.html",type = "redirect")})
    public String editCourier(){
        courierService.save(getModel());
        return "editCourierSuccess";
    }

    /**
     * 分页查询
     * @return
     * @throws IOException
     */
    @Action(value = "courierAction_pageQuery")
    public String pageQuery() throws IOException {
        List<Customer> findAll = customerProxy.findAll();

        final String company = getModel().getCompany();
        final String courierNum = getModel().getCourierNum();
        final String type = getModel().getType();
        final Standard standard = getModel().getStandard();
        Specification<Courier> specification = new Specification<Courier>() {
            @Override
            public Predicate toPredicate(Root<Courier> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> list = new ArrayList<>();
                if(StringUtils.isNoneBlank(company)){
                    Predicate p1 = cb.like(root.get("company").as(String.class), company);
                    list.add(p1);
                }
                if(StringUtils.isNoneBlank(courierNum)){
                    Predicate p2 = cb.equal(root.get("courierNum").as(String.class), courierNum);
                    list.add(p2);
                }
                if(StringUtils.isNoneBlank(type)){
                    Predicate p3 = cb.equal(root.get("type").as(String.class), type);
                    list.add(p3);
                }
                if(standard!=null&&StringUtils.isNoneBlank(standard.getName())){
                    Join<Object, Object> join = root.join("standard");
                    Predicate p4 = cb.equal(join.get("name").as(String.class), standard.getName());
                    list.add(p4);
                }
                if(list.size()==0){
                    return null;
                }
                Predicate[] ps = new Predicate[list.size()];
                return cb.and(list.toArray(ps));
            }
        };

        Pageable pageable = new PageRequest(page-1,rows);
        Page<Courier> page = courierService.pageQuery(specification,pageable);
        this.page2Json(page);
        return NONE;
    }

    @Action(value="courierAction_save",results = {@Result(name="saveCourierSuccess",location = "/pages/base/courier.html",type = "redirect")})
    public String saveCourier(){
        courierService.save(getModel());
        return "saveCourierSuccess";
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public void setCourierService(ICourierService courierService) {
        this.courierService = courierService;
    }

}
