package com.zxit.dao;

import com.zxit.model.Ajb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author nanxiaofeng
 * @date 2018
 * 案件类型表操作
 */
public interface AjbRepository extends JpaRepository<Ajb, String> {

    /**
     * 案件类型
     * @return
     */
    @Query(value = "select distinct(ajlx) from Ajb ")
    List<Ajb> findAjlx();

    /**
     * 通过案件类型查询案件性质
     * @param ajlx
     * @return
     */
    @Query(value = "select distinct (ajxz) from Ajb where ajlx = ?1")
    List<Ajb> findByAjlx(String ajlx);

    /**
     * 查询性质分类
     * @param ajlx
     * @param ajxz
     * @return
     */
    @Query(value = "select distinct (xzfl) from Ajb where ajlx = ?1 and ajxz = ?2")
    List<Ajb> findByAjlxAndAjxz(String ajlx, String ajxz);

    /**
     * 查询性质细类
     * @param ajlx
     * @param ajxz
     * @param xzfl
     * @return
     */
    @Query(value = "select distinct (xzxl) from Ajb where ajlx = ?1 and ajxz = ?2 and xzfl = ?3")
    List<Ajb> findByAjlxAndAjxzAndXzfl(String ajlx, String ajxz, String xzfl);

    /**
     * 定位性质细类
     * @param ajlx
     * @param ajxz
     * @param xzfl
     * @param xzxl
     * @return
     */
    List<Ajb> findByAjlxAndAjxzAndXzflAndXzxl(String ajlx, String ajxz, String xzfl, String xzxl);
}