package com.zxit.service.impl;


import com.zxit.model.Jjdwb;
import com.zxit.dao.JjdwbRepository;
import com.zxit.service.JjdwbService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class JjdwbServiceImpl implements JjdwbService {

    @Resource
    private JjdwbRepository jjdwbRepository;

    @Override
    public List<Jjdwb> findAll(Sort sort) {
        List<Jjdwb> list = jjdwbRepository.findAll(sort);
        return list;
    }
}
    



