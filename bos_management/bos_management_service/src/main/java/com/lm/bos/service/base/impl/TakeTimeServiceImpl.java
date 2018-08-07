package com.lm.bos.service.base.impl;

import com.lm.bos.dao.base.ITakeTimeDao;
import com.lm.bos.domain.base.TakeTime;
import com.lm.bos.service.base.ITakeTimeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class TakeTimeServiceImpl implements ITakeTimeService {

    @Resource
    private ITakeTimeDao takeTimeDao;

    @Override
    public List<TakeTime> findAll() {
        return takeTimeDao.findAll();
    }
}
