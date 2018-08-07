package com.lm.bos.service.take_delivery.impl;

import com.lm.bos.dao.take_delivery.IWaybillDao;
import com.lm.bos.domain.take_delivery.WayBill;
import com.lm.bos.service.take_delivery.IWaybillService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.jws.WebService;

@Service
@Transactional
@WebService
public class WaybillServiceImpl implements IWaybillService {

    @Resource
    private IWaybillDao waybillDao;

    @Override
    public void save(WayBill model) {
        waybillDao.save(model);
    }
}
