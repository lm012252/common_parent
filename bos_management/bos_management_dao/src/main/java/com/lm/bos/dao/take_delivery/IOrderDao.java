package com.lm.bos.dao.take_delivery;

import com.lm.bos.domain.take_delivery.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderDao extends JpaRepository<Order,Integer> {
}
