package com.zxit.service.impl;

import com.zxit.share.Constants;
import com.zxit.model.Ajb;
import com.zxit.dao.AjbRepository;
import com.zxit.service.AjbService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class AjbServiceImpl  implements AjbService {

    @Resource
    private AjbRepository ajbRepository;

    @Override
    public List<String> findAjlx() {
        List<String> list = Arrays.asList(Constants.AJB_SORT);
        return list;
    }

    @Override
    public Ajb findOne(String id) {
        return null;
    }

    @Override
    public List<Ajb> findAll() {
        List<Ajb> list = ajbRepository.findAll();
        return list;
    }

    @Override
    public List<Ajb> findByAjlx(String ajlx) {
        List<Ajb> list = ajbRepository.findByAjlx(ajlx);
        return list;
    }

    @Override
    public List<Ajb> findByAjlxAndAjxz(String ajlx, String ajxz) {
        List<Ajb> list = ajbRepository.findByAjlxAndAjxz(ajlx, ajxz);
        return list;
    }

    @Override
    public List<Ajb> findByAjlxAndAjxzAndXzfl(String ajlx, String ajxz, String xzfl) {
        List<Ajb> list = ajbRepository.findByAjlxAndAjxzAndXzfl(ajlx, ajxz, xzfl);
        return list;
    }

    @Override
    public List<Ajb> findByAjlxAndAjxzAndXzflAndXzxl(String ajlx, String ajxz, String xzfl, String xzxl) {
        List<Ajb> list = ajbRepository.findByAjlxAndAjxzAndXzflAndXzxl(ajlx, ajxz, xzfl, xzxl);
        return list;
    }


}
    



