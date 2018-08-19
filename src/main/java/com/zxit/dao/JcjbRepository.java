package com.zxit.dao;

import com.zxit.model.Jcjb;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author nanxiaofeng
 * @date 2018
 * 接警流水表
 */
public interface JcjbRepository extends JpaRepository<Jcjb, String>, JpaSpecificationExecutor<Jcjb> {

    /**
     * 通过接警流水号查询警情
     * @param jjh
     * @return
     */
    Jcjb findByJjh(String jjh);

}