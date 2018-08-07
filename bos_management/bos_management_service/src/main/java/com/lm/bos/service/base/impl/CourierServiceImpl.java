package com.lm.bos.service.base.impl;

import com.lm.bos.dao.base.ICourierDao;
import com.lm.bos.domain.base.Courier;
import com.lm.bos.service.base.ICourierService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class CourierServiceImpl implements ICourierService {

    @Resource
    private ICourierDao courierDao;

    @Override
    public void save(Courier model) {
        courierDao.save(model);
    }

    @Override
    public Page<Courier> pageQuery(Specification<Courier> specification,Pageable pageable) {
        return courierDao.findAll(specification,pageable);
    }

    @Override
    public void delete(String ids) {
        if(StringUtils.isNoneBlank(ids)){
            String[] courierIds = ids.split(",");
            for (String courierId : courierIds) {
                courierDao.update(courierId);
            }
        }
    }

    @Override
    public void restore(String ids) {
        if(StringUtils.isNoneBlank(ids)){
            String[] courierIds = ids.split(",");
            for (String courierId : courierIds) {
                courierDao.restore(Integer.parseInt(courierId));
            }
        }
    }

    @Override
    public List<Courier> findAll() {
        return courierDao.findAll();
    }

    @Override
    public List<Courier> findByDeltagIsNull() {
        return courierDao.findByDeltagIsNull();
    }

    public void setCourierDao(ICourierDao courierDao) {
        this.courierDao = courierDao;
    }
}
