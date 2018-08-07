package com.lm.bos.web.action.base;

import com.alibaba.fastjson.JSON;
import com.lm.bos.domain.base.Area;
import com.lm.bos.service.base.IAreaService;
import com.lm.bos.web.action.common.CommonAction;
import org.apache.commons.lang3.StringUtils;
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
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Namespace("/")
@ParentPackage("struts-default")
@Controller
@Scope("prototype")
public class AreaAction extends CommonAction<Area> {

    @Resource
    private IAreaService areaService;
    //导入的文件
    private File areaFile;
    private String q;

    public void setQ(String q) {
        this.q = q;
    }

    @Action(value = "areaAction_findAll")
    public String findAll() throws IOException {
        List<Area> list=null;
        System.out.println(q);
        if(StringUtils.isNoneBlank(q)){
            list = areaService.findByQ("%"+q.toUpperCase()+"%");
        }else{
            list = areaService.findAll();
        }
        this.list2Json(list);
        return NONE;
    }


    /**
     * 分页查询
     * @return
     * @throws IOException
     */
    @Action(value="areaAction_pageQuery")
    public String pageQuery() throws IOException {
        Pageable pageable = new PageRequest(page-1,rows);
        Page<Area> page = areaService.pageQuery(pageable);
        this.page2Json(page);
        return NONE;
    }

    /**
     * 导入文件
     * @return
     * @throws IOException
     */
    @Action(value = "areaAction_importXls",results = {@Result(name="importXlsSuccess",location = "/pages/base/area.html",type = "redirect")})
    public String importXls() throws IOException {
        areaService.importXls(areaFile);
        return "importXlsSuccess";
    }

    public void setAreaFile(File areaFile) {
        this.areaFile = areaFile;
    }


}
