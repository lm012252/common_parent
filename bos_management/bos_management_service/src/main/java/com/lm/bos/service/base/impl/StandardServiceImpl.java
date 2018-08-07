package com.lm.bos.service.base.impl;

import com.lm.bos.dao.base.IStandardDao;
import com.lm.bos.domain.base.Standard;
import com.lm.bos.service.base.IStandardService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class StandardServiceImpl implements IStandardService {

    @Resource
    private IStandardDao standardDao;

    @Override
    public void save(Standard model) {
        standardDao.save(model);
    }

    @Override
    public Page<Standard> pageQuery(Pageable pageable) {
        return standardDao.findAll(pageable);
    }

    @Override
    public List<Standard> findAll() {
        return standardDao.findAll();
    }
}
