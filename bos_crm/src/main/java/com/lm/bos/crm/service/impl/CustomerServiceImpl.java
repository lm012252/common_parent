package com.lm.bos.crm.service.impl;

import com.lm.bos.crm.dao.ICustomerDao;
import com.lm.bos.crm.domain.Customer;
import com.lm.bos.crm.service.ICustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@Service
@Transactional
@WebService
public class CustomerServiceImpl implements ICustomerService {

    @Resource
    private ICustomerDao customerDao;

    @Override
    public List<Customer> findAll() {
        return customerDao.findAll();
    }

    @Override
    public List<Customer> findByFixedAreaIdIsNull() {
        return customerDao.findByFixedAreaIdIsNull();
    }

    @Override
    public List<Customer> findByFixedAreaId(@WebParam(name="fixedAreaId")String fixedAreaId) {
        return customerDao.findByFixedAreaId(fixedAreaId);
    }

    @Override
    public void assignCustomers2FixedArea(@WebParam(name="fixedAreaId")String fixedAreaId, @WebParam(name="customerIds")List<Integer> customerIds) {
        //根据定区id，将客户表定区id更新为null
        customerDao.setFixedAreaIdIsNull(fixedAreaId);
        //重新定义关联，将传入的客户ids关联到定区
        for (Integer customerId : customerIds) {
            customerDao.assignCustomers2FixedArea(fixedAreaId,customerId);
        }
    }

    @Override
    public void regist(@WebParam(name = "customer") Customer customer) {
        //密码进行md5加密
        customerDao.save(customer);
    }

    @Override
    public Customer findByTelephone(@WebParam(name = "telephone")String telephone) {
        return customerDao.findByTelephone(telephone);
    }

    @Override
    public void activeMail(@WebParam(name = "telephone")String telephone) {
        customerDao.activeMail(telephone);
    }

    @Override
    public Customer login(@WebParam(name = "telephone")String telephone, @WebParam(name = "password")String password) {
        return customerDao.findByTelephoneAndPassword(telephone,password);
    }

    @Override
    public String findFixedAreaIdByAddress(String address) {
        return customerDao.findFixedAreaIdByAddress(address);
    }
}
