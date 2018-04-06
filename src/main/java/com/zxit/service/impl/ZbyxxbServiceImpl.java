package com.zxit.service.impl;

import com.zxit.model.Zbyxxb;
import com.zxit.dao.ZbyxxbRepository;
import com.zxit.service.ZbyxxbService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ZbyxxbServiceImpl implements ZbyxxbService {

    @Resource
    private ZbyxxbRepository zbyxxbRepository;

    @Override
    public Zbyxxb findOne(String id) {
        Zbyxxb zbyxxb = zbyxxbRepository.findOne(id);
        return zbyxxb;
    }

    @Override
    public List<Zbyxxb> findAll() {
        Sort sort = new Sort(Sort.Direction.DESC, "xm");
        List<Zbyxxb> list = zbyxxbRepository.findAll(sort);
        return list;
    }

    @Override
    public Zbyxxb findZbyxxbByIdAndMm(String id, String mm) {
        Zbyxxb zbyxxb = zbyxxbRepository.findZbyxxbByIdAndMm(id, mm);
        return zbyxxb;
    }
}
    



