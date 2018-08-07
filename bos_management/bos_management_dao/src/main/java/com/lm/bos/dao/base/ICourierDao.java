package com.lm.bos.dao.base;

import com.lm.bos.domain.base.Courier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICourierDao extends JpaRepository<Courier,Integer>,JpaSpecificationExecutor<Courier> {

    //nativeQuery默认使用JPQL  设置为true就为使用sql语句
    @Modifying//修改删除
    @Query(value="update T_COURIER set C_DELTAG = 1 where C_ID = ? ",nativeQuery=true)
    void update(String courierId);

    @Modifying//修改还原
    @Query(value="update Courier set deltag = '' where id = ?1")//默认使用JPQL
    void restore(Integer courierId);

    /**
     * 查询未失效的快递员
     * @return
     */
    List<Courier> findByDeltagIsNull();
}
