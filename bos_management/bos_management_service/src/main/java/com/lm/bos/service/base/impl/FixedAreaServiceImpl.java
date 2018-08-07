package com.lm.bos.service.base.impl;

import com.lm.bos.dao.base.ICourierDao;
import com.lm.bos.dao.base.IFixedAreaDao;
import com.lm.bos.dao.base.ITakeTimeDao;
import com.lm.bos.domain.base.Courier;
import com.lm.bos.domain.base.FixedArea;
import com.lm.bos.domain.base.TakeTime;
import com.lm.bos.service.base.IFixedAreaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class FixedAreaServiceImpl implements IFixedAreaService {

    @Resource
    private IFixedAreaDao fixedAreaDao;

    @Resource
    private ICourierDao courierDao;

    @Resource
    private ITakeTimeDao takeTimeDao;

    @Override
    public void save(FixedArea model) {
        fixedAreaDao.save(model);
    }

    @Override
    public Page<FixedArea> pageQuery(Pageable pageable) {
        return fixedAreaDao.findAll(pageable);
    }

    @Override
    public void associationCourierToFixedArea(String id, Integer courierId, Integer takeTimeId) {
        //根据定区id查询定区对象
        System.out.println("id=" + id);
        FixedArea fixedArea = fixedAreaDao.findOne(id);
        System.out.println("fixedArea=" + fixedArea);
        //根据courierId查询快递员对象
        Courier courier = courierDao.findOne(courierId);
        //定区关联快递员
        fixedArea.getCouriers().add(courier);
        //根据takeTimeId查询取派时间对象
        TakeTime takeTime = takeTimeDao.findOne(takeTimeId);
        //快递员关联取派时间
        courier.setTakeTime(takeTime);
    }
}
