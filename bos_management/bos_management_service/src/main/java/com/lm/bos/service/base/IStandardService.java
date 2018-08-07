package com.lm.bos.service.base;

import com.lm.bos.domain.base.Standard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStandardService {
    void save(Standard model);

    Page<Standard> pageQuery(Pageable pageable);

    List<Standard> findAll();
}
