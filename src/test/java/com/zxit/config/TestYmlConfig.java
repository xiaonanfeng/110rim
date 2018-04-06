package com.zxit.config;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestYmlConfig {

    @Resource
    private YmlConfig ymlConfig;

    @Test
    public void test_YmlConfig(){
        System.out.println(ymlConfig.toString());
    }

}
    



