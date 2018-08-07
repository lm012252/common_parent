package com.lm.bos.web.action.base;

import com.alibaba.fastjson.JSON;
import com.lm.bos.domain.base.Standard;
import com.lm.bos.service.base.IStandardService;
import com.lm.bos.web.action.common.CommonAction;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Namespace("/")
@ParentPackage("struts-default")
@Controller
@Scope("prototype")
public class StandardAction extends CommonAction<Standard> {
    @Resource
    private IStandardService standardService;

    //查询所有的取派标准
    @Action(value = "standardAction_findAll")
    public String findAll() throws IOException {
        List<Standard> list = standardService.findAll();
        System.out.println("list="+list);
        this.list2Json(list);
        return NONE;
    }

    //分页查询
    @Action(value = "standardAction_pageQuery")
    public String pageQuery() throws IOException {
        //封装成一个Pageable对象
        //page从easyui获取的值从1开始，jpa从0开始
        Pageable pageable = new PageRequest(page - 1, rows);
        //调用service层
        Page<Standard> page = standardService.pageQuery(pageable);
        this.page2Json(page);
        return NONE;
    }

    //保存
    @Action(value="standardAction_save",results = {@Result(name="saveStandardSuccess",location = "/pages/base/standard.html",type = "redirect")})
    public String saveStandard(){
        standardService.save(getModel());
        return "saveStandardSuccess";
    }

}
