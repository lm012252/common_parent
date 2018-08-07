package com.lm.bos.dao.take_delivery;

import com.lm.bos.domain.take_delivery.WorkBill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IWorkBillDao extends JpaRepository<WorkBill,Integer> {
}
