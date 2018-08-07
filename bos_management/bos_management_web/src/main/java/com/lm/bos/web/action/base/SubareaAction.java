package com.lm.bos.web.action.base;

import com.lm.bos.domain.base.SubArea;
import com.lm.bos.service.base.ISubareaService;
import com.lm.bos.web.action.common.CommonAction;
import org.apache.poi.ss.formula.functions.T;
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

@Namespace("/")
@ParentPackage("struts-default")
@Controller
@Scope(value = "prototype")
public class SubareaAction extends CommonAction<SubArea> {

    @Resource
    private ISubareaService subareaService;

    /**
     * 分页查询
     * @return
     */
    @Action(value = "subareaAction_pageQuery")
    public String pageQuery() throws IOException {
        Pageable pageable = new PageRequest(page-1,rows);
        Page<SubArea> page = subareaService.pageQuery(pageable);
        this.page2Json(page);
        return NONE;
    }

    /**
     * 保存分区
     * @return
     */
    @Action(value="subareaAction_save",results = {@Result(name="saveSubareaSuccess",location = "/pages/base/sub_area.html",type = "redirect")})
    public String saveSubarea(){
        if(getModel().getArea().getCity()==""){
            getModel().getArea().setCity(getModel().getArea().getProvince());
        }
        subareaService.save(getModel());
        return "saveSubareaSuccess";
    }


}
