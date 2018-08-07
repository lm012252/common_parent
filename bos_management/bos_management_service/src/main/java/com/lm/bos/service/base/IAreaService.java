package com.lm.bos.service.base;

import com.lm.bos.domain.base.Area;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface IAreaService {
    void importXls(File areaFile) throws IOException;

    Page<Area> pageQuery(Pageable pageable);

    List<Area> findAll();

    List<Area> findByQ(String q);
}
