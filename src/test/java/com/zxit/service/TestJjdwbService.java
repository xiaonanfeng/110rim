package com.zxit.service;


import com.alibaba.fastjson.JSON;
import com.zxit.model.Jjdwb;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestJjdwbService {

    @Resource
    private JjdwbService jjdwbService;

    @Test
    public void test_findJjdwb() {
        Sort sort = new Sort(Sort.Direction.ASC, "xh");
        List<Jjdwb> list = jjdwbService.findAll(sort);
        System.out.println(JSON.toJSONString(list));
    }

}
    



