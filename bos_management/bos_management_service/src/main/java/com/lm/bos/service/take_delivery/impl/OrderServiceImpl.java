package com.lm.bos.service.take_delivery.impl;

import com.lm.bos.crm.service.CustomerServiceImpl;
import com.lm.bos.dao.base.IAreaDao;
import com.lm.bos.dao.base.IFixedAreaDao;
import com.lm.bos.dao.base.ISubareaDao;
import com.lm.bos.dao.take_delivery.IOrderDao;
import com.lm.bos.dao.take_delivery.IWorkBillDao;
import com.lm.bos.domain.base.Area;
import com.lm.bos.domain.base.Courier;
import com.lm.bos.domain.base.FixedArea;
import com.lm.bos.domain.base.SubArea;
import com.lm.bos.domain.take_delivery.Order;
import com.lm.bos.domain.take_delivery.WorkBill;
import com.lm.bos.service.take_delivery.IOrderService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
@WebService
@Transactional
public class OrderServiceImpl implements IOrderService {

    private static Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

    //因为使用到了customer服务，所以需要将customer也打开
    @Resource
    private CustomerServiceImpl customerProxy;

    @Resource
    private IOrderDao orderDao;

    @Resource
    private IAreaDao areaDao;

    @Resource
    private ISubareaDao subareaDao;

    @Resource
    private IFixedAreaDao fixedAreaDao;

    @Resource
    private IWorkBillDao workBillDao;

    @Override
    public void save(@WebParam(name = "order") Order order) {
        String orderType = "";
        Area sendArea = areaDao.findByProvinceAndCityAndDistrict(order.getSendArea().getProvince(),
                order.getSendArea().getCity(),order.getSendArea().getDistrict());
        Area recArea = areaDao.findByProvinceAndCityAndDistrict(order.getSendArea().getProvince(),
                order.getSendArea().getCity(),order.getSendArea().getDistrict());
        log.info("接收订单数据："+order.toString());
        //调用crm服务根据地址查询定区id
        String sendAddress2 = order.getSendAddress();
        String sendAddress = sendAddress2;
        String fixedAreaId = customerProxy.findFixedAreaIdByAddress(sendAddress);
        Courier cr = null;
        if(StringUtils.isNotBlank(fixedAreaId)){
            //根据定区id查询定区对象,然后通过定区查询取派员
            FixedArea fixedArea = fixedAreaDao.findOne(fixedAreaId);
            //设置订单状态 （自动分单） 将订单关联取派员
            order.setStatus("1");
            //发送短信给快递员
            System.out.println("发送短信给客户...");
            //通过定区查询快递员
            Set<Courier> couriers = fixedArea.getCouriers();
            for (Courier courier : couriers) {
                cr = courier;
                orderType = "自动分单";
                //判断当前取派员是否在上班时间内
                this.generateWorkBill(order, cr);
                break;
            }
        }else{
            //自动分单：第二种方式：（前提：第一种方式分单失败）
            //根据省市区查询分区数据
            //基于分区关键字匹配实现自动分单
            String areaId = sendArea.getId();
            //通过区域id查询定区
            List<SubArea> subareas = subareaDao.findByAreaId(areaId);
            String address = order.getSendAddress();
            for (SubArea subarea : subareas) {
                String keyWords = subarea.getKeyWords();
                String assistKeyWords = subarea.getAssistKeyWords();
                if(address.contains(keyWords)||address.contains(assistKeyWords)){
                    //获取分区所属定区里面的快递员
                    Set<Courier> couriers = subarea.getFixedArea().getCouriers();
                    //判断当前定区是否有快递员
                    //正常逻辑是判断当前定区是否存在可工作的快递员
                    if(couriers!=null&&couriers.size()>0){
                        for (Courier courier : couriers) {
                            if (courier != null) {
                                // 匹配到快递员，可以完成自动分单
                                cr = courier;
                                orderType = "自动分单";
                                // 生成工单，给快递员发送短信
                                generateWorkBill(order,courier);
                                break;
                            }
                        }
                    }
                }
            }
        }
        if(sendArea==null){
            log.warn("发件人省市区为空");
        }
        if(recArea==null){
            log.warn("收件人省市区为空");
        }
        if (orderType==null) {
            order.setOrderType("手动分单");
        }else{
            order.setOrderType(orderType);
        }
        order.setOrderNum(UUID.randomUUID().toString());
        order.setCourier(cr);
        order.setOrderTime(new Date());
        order.setSendArea(sendArea);
        order.setRecArea(recArea);
        //保存订单
        orderDao.save(order);
    }
    public void generateWorkBill(Order order,Courier cr){
        WorkBill workBill = new WorkBill();
        workBill.setType("1");//1:新单   2：追   3：销
        workBill.setPickstate("1");//1：未取件 2：取件中 3：已取件
        workBill.setBuildtime(new Date());//订单生成时间
        workBill.setAttachbilltimes(1);//追单次数
        workBill.setRemark(order.getRemark());//备注
        workBill.setSmsNumber("1234567890123456");//短信序号
        workBill.setCourier(cr);
        workBill.setOrder(order);
        workBillDao.save(workBill);
    }

}
