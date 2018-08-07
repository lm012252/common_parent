package com.lm.bos.dao.base;

import com.lm.bos.domain.base.Standard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IStandardDao extends JpaRepository<Standard,Integer> {
    //根据姓名查对象
    public Standard findByName(String name);

    //根据姓名和操作查询对象
    public Standard findByNameAndOperator(String name,String operator);

    //根据姓名模糊查询对象
    public List<Standard> findByNameLike(String name);
    //属性名称首字母大写
    public List<Standard> findByOperatorIsNull();

    //自定义命名查询数据 JPQL
    @Query("FROM Standard WHERE name = ?1")
    public Standard findByNamexxx(String name);


    //自定义命名查询数据 SQL
    @Query(value="select * from t_standard where c_name = ? ",nativeQuery=true) //jpql
    public Standard findByNamexx(String name);

}
