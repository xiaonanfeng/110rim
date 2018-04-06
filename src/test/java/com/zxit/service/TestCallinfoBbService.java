package com.zxit.service;

import com.alibaba.fastjson.JSON;
import com.zxit.model.CallinfoBb;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCallinfoBbService {

    @Resource
    private CallinfoBbService callinfoBbService;

    @Test
    public void test_findCallinfoBbByEventid(){
        List<CallinfoBb> list = callinfoBbService.findCallinfoBbByEventid("2014011706100000100");
        System.out.println(JSON.toJSONString(list));
    }

}
    



