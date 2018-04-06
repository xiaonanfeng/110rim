package com.zxit.service.impl;

import com.zxit.model.CallinfoBb;
import com.zxit.dao.CallinfoBbRepository;
import com.zxit.service.CallinfoBbService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CallinfoBbServiceImpl implements CallinfoBbService {

    @Resource
    private CallinfoBbRepository callinfoBbRepository;

    @Override
    public CallinfoBb findOne(String guid) {
        CallinfoBb callinfoBb = callinfoBbRepository.findOne(guid);
        return callinfoBb;
    }

    @Override
    public List<CallinfoBb> findCallinfoBbByEventid(String eventid) {
        List<CallinfoBb> list = callinfoBbRepository.findCallinfoBbByEventid(eventid);
        return list;
    }

    @Override
    public String findRecPathByEventId(String guid) {

        return null;
    }
}
    



