package com.lm.bos.service.take_delivery;

import com.lm.bos.domain.take_delivery.Order;

/**
 * 订单模块业务逻辑层
 */
public interface IOrderService {
    /**
     * 保存订单
     * @param order
     */
    void save(Order order);

}
