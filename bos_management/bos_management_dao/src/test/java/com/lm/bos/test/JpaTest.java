package com.lm.bos.test;

import com.lm.bos.dao.base.IStandardDao;
import com.lm.bos.domain.base.Standard;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class JpaTest {

    //注入dao
    @Resource
    private IStandardDao standardDao;

    //查询所有数据
    @Test
    public void findAll(){
        List<Standard> findAll = standardDao.findAll();
        System.out.println(findAll == null ? "没有数据":"size="+findAll.size());
    }

    //保存
    @Test
    public void save(){
        Standard standard = new Standard();
        standard.setName("标准二");
        Standard save = standardDao.save(standard);
        System.out.println(save.toString());
    }

    //更新
    @Test
    public void update(){
        Standard standard = new Standard();
        standard.setId(21);
        standard.setName("标准二");
        Standard save = standardDao.saveAndFlush(standard);
        System.out.println(save.toString());
    }

    //删除
    @Test
    public void delete(){
        Standard standard = new Standard();
        standard.setId(4);
        standardDao.delete(standard);
    }

    //根据id查询数据
    @Test
    public void findById(){
        Standard one = standardDao.findOne(22);
        System.out.println("one=" + one);
    }

    //根据名称查询数据(查询方法命名规则)
    @Test
    public void findByName(){
        Standard standard = standardDao.findByName("标准一");
        System.out.println("standard="+standard);
    }

    //根据名称以及操作人查询数据(查询方法命名规则)
    @Test
    public void findByNameAndOperator(){
        Standard byNameAndOperator = standardDao.findByNameAndOperator("标准一", "欧阳梦萍");
        System.out.println("byNameAndOperator=" + byNameAndOperator);
    }

    //根据名称模糊查询数据(查询方法命名规则)
    @Test
    public void findByNameLike(){
        List<Standard> list = standardDao.findByNameLike("%标准%");
        for (Standard standard : list) {
            System.out.println("standard=" + standard);
        }
    }

    //查询操作人为空数据(查询方法命名规则)
    @Test
    public void findByOperatorIsNull(){
        List<Standard> list = standardDao.findByOperatorIsNull();
        for (Standard standard : list) {
            System.out.println("standard=" + standard);
        }
    }

    //自定义名称查询数据 JPQL
    @Test
    public void findByNamexxx(){
        Standard findByName = standardDao.findByNamexxx("标准二");
        System.out.println(findByName.toString());
    }


    //自定义名称查询数据 SQL
    @Test
    public void findByNamexx(){
        Standard findByName = standardDao.findByNamexx("标准二");
        System.out.println(findByName.toString());
    }

}
