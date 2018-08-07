package com.lm.bos.service.base;

import com.lm.bos.domain.base.SubArea;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ISubareaService {
    void save(SubArea model);

    Page<SubArea> pageQuery(Pageable pageable);
}
