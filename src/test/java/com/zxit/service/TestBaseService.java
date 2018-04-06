package com.zxit.service;


import com.alibaba.fastjson.JSON;
import com.zxit.model.Ajb;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestBaseService {

    @Resource
    private ABaseService aBaseService;

    @Test
    public void test_abase(){
        List<Ajb> list = aBaseService.findAll(Ajb.class);
        System.out.println(JSON.toJSONString(list));

    }

}
    



