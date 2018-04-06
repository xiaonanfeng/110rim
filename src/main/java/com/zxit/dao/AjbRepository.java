package com.zxit.dao;

import com.zxit.model.Ajb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AjbRepository extends JpaRepository<Ajb, String> {

    @Query(value = "select distinct(ajlx) from Ajb ")
    List<Ajb> findAjlx();

    @Query(value = "select distinct (ajxz) from Ajb where ajlx = ?1")
    List<Ajb> findByAjlx(String ajlx);

    @Query(value = "select distinct (xzfl) from Ajb where ajlx = ?1 and ajxz = ?2")
    List<Ajb> findByAjlxAndAjxz(String ajlx, String ajxz);

    @Query(value = "select distinct (xzxl) from Ajb where ajlx = ?1 and ajxz = ?2 and xzfl = ?3")
    List<Ajb> findByAjlxAndAjxzAndXzfl(String ajlx, String ajxz, String xzfl);

    List<Ajb> findByAjlxAndAjxzAndXzflAndXzxl(String ajlx, String ajxz, String xzfl, String xzxl);
}