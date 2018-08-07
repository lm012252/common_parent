package com.lm.bos.web.action.base;

import com.lm.bos.domain.base.TakeTime;
import com.lm.bos.service.base.ITakeTimeService;
import com.lm.bos.web.action.common.CommonAction;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.context.annotation.Scope;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@Namespace("/")
@ParentPackage("struts-default")
@Action
@Scope("prototype")
public class TakeTimeAction extends CommonAction<TakeTime> {

    @Resource
    private ITakeTimeService takeTimeService;

    @Action(value="takeTimeAction_listajax")
    public String listajax() throws IOException {
        List<TakeTime> list =  takeTimeService.findAll();
        this.list2Json(list);
        return NONE;
    }

}
