package com.lm.bos.dao.base;

import com.lm.bos.domain.base.SubArea;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISubareaDao extends JpaRepository<SubArea,String> {

    /**
     * 根据区域id查询当前区域的分区
     * @param id
     * @return
     */
    List<SubArea> findByAreaId(String id);
}
