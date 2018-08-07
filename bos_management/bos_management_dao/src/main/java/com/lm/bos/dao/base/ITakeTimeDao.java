package com.lm.bos.dao.base;

import com.lm.bos.domain.base.TakeTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITakeTimeDao extends JpaRepository<TakeTime,Integer> {
}
