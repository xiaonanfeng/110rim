package com.zxit.dao;

import com.zxit.model.Jcjb;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface JcjbRepository extends JpaRepository<Jcjb, String>, JpaSpecificationExecutor<Jcjb> {

    Jcjb findByJjh(String jjh);

}