package com.lm.bos.crm.service;

import com.lm.bos.crm.domain.Customer;

import javax.jws.WebParam;
import java.util.List;

public interface ICustomerService {
    /**
     * 查询所有客户的信息
     * @return
     */
    List<Customer> findAll();

    /**
     * 查询未关联定区客户信息
     * @return
     */
    List<Customer> findByFixedAreaIdIsNull();

    /**
     * 查询已经关联定区的客户信息
     * @param fixedAreaId
     * @return
     */
    List<Customer> findByFixedAreaId(String fixedAreaId);

    /**
     * 将客户关联到定区
     * @param fixedAreaId
     * @param customerIds
     */
    void assignCustomers2FixedArea(String fixedAreaId, List<Integer> customerIds);

    /**
     * 注册用户
     * @param customer
     */
    void regist(Customer customer);

    /**
     * 根据手机号查询用户
     * @param telephone
     * @return
     */
    Customer findByTelephone(String telephone);

    /**
     * 根据手机号激活用户
     * @param telephone
     */
    void activeMail(String telephone);

    /**
     * 用户登录
     * @param telephone
     * @param password
     * @return
     */
    Customer login(String telephone,String password);

    /**
     * 根据地址查询定区id
     * @param address
     * @return
     */
    String findFixedAreaIdByAddress(String address);
}
