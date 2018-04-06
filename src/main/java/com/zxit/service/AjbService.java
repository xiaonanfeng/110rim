package com.zxit.service;


import com.zxit.model.Ajb;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by xiaonanfeng on 2018/3/31.
 * 每天都在写BUG！
 */
public interface AjbService {

    Ajb findOne(String id);

    List<Ajb> findAll();

    List<String> findAjlx();

    List<Ajb> findByAjlx(String ajlx);

    List<Ajb> findByAjlxAndAjxz(String ajlx, String ajxz);

    List<Ajb> findByAjlxAndAjxzAndXzfl(String ajlx, String ajxz, String xzfl);

    List<Ajb> findByAjlxAndAjxzAndXzflAndXzxl(String ajlx, String ajxz, String xzfl, String xzxl);

}
