package com.lm.bos.service.base;

import com.lm.bos.domain.base.Courier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface ICourierService {
    void save(Courier model);

    Page<Courier> pageQuery(Specification<Courier> specification, Pageable pageable);

    void delete(String ids);

    void restore(String ids);

    List<Courier> findAll();

    /**
     * 查询未失效的快递员
     * @return
     */
    List<Courier> findByDeltagIsNull();
}
