package com.lm.bos.web.action.common;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.springframework.data.domain.Page;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 公共的Action
 */
public class CommonAction<T> extends ActionSupport implements ModelDriven<T> {

    private T model;
    protected Integer page;
    protected  Integer rows;
    public CommonAction() {
        //获取父类的对象
        ParameterizedType superclass = (ParameterizedType) this.getClass().getGenericSuperclass();
        //获取父类泛型上的数组
        Type[] actualTypeArguments = superclass.getActualTypeArguments();
        //实体的类型
        Class<T> entityClass = (Class<T>)actualTypeArguments[0];
        //通过反射获取实体对象
        try {
            model = entityClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * page转json
     * @param page
     */
    public void page2Json(Page page) throws IOException {
        long totalElements = page.getTotalElements();
        List<T> content = page.getContent();
        Map<String, Object> map = new HashMap<>();
        map.put("total",totalElements);
        map.put("rows",content);
        String data = JSON.toJSONString(map);
        ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
        ServletActionContext.getResponse().getWriter().print(data);
    }

    /**
     * list转json
     * @param list
     */
    public void list2Json(List list) throws IOException {
        String data = JSON.toJSONString(list);
        ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
        ServletActionContext.getResponse().getWriter().print(data);
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public void setPage(Integer page) {
        this.page = page;
    }
    @Override
    public T getModel() {
        return model;
    }

}
