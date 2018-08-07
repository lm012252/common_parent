package com.lm.bos.service.take_delivery;


import com.lm.bos.domain.take_delivery.WayBill;

public interface IWaybillService {
    /**
     * 保存运单
     * @param model
     */
    void save(WayBill model);
}
