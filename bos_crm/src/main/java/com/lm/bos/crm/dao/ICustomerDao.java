package com.lm.bos.crm.dao;

import com.lm.bos.crm.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICustomerDao extends JpaRepository<Customer,Integer> {

    /**
     * 查询未关联定区的客户
     * @return
     */
    List<Customer> findByFixedAreaIdIsNull();

    /**
     * 查询已经关联定区的客户
     * @param fixedAreaId
     * @return
     */
    List<Customer> findByFixedAreaId(String fixedAreaId);

    /**
     * 根据定区id取消当前定区id已经关联的客户的定区设置为null
     * @param fixedAreaId
     */
    @Query("update Customer set fixedAreaId = null where fixedAreaId = ?1")
    //@Query(value="update T_CUSTOMER set fixedAreaId = null where fixedAreaId = ?1",nativeQuery = true)
    @Modifying
    void setFixedAreaIdIsNull(String fixedAreaId);

    /**
     * 将客户关联定区
     * @param fixedAreaId
     * @param customerId
     */
    @Query("update Customer set fixedAreaId = ?1 where id = ?2")
    //@Query(value="update T_CUSTOMER set fixedAreaId = ?1 where customerId = ?2",nativeQuery = true)
    @Modifying
    void assignCustomers2FixedArea(String fixedAreaId, Integer customerId);

    /**
     * 根据手机号查询用户
     * @param telephone
     * @return
     */
    Customer findByTelephone(String telephone);

    /**
     * 根据手机号激活账号
     * @param telephone
     */
    @Query(value = "update Customer set type = 1 where telephone = ?1")
    @Modifying
    void activeMail(String telephone);

    /**
     * 根据电话和密码查询用户(JPA规范)
     * @return
     */
    Customer findByTelephoneAndPassword(String telephone, String password);

    /**
     * 根据地址查询定区id
     * @param address
     * @return
     */
    @Query(value = "select fixedAreaId from Customer where address = ?1")
    String findFixedAreaIdByAddress(String address);
}
