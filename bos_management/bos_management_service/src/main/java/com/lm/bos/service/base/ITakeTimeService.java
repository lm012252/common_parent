package com.lm.bos.service.base;

import com.lm.bos.domain.base.TakeTime;

import java.util.List;

public interface ITakeTimeService {
    List<TakeTime> findAll();
}
