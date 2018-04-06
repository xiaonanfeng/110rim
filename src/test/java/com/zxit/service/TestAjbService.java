package com.zxit.service;

import com.alibaba.fastjson.JSON;
import com.zxit.model.Ajb;
import com.zxit.service.AjbService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestAjbService {

    @Resource
    private AjbService ajbService;

    @Test
    public void test_Ajb(){
        Ajb ajb = ajbService.findOne("admin");
        System.out.println(JSON.toJSONString(ajb));
    }

    @Test
    public void test_findAjlx(){
        List<String> list = ajbService.findAjlx();
        System.out.println(JSON.toJSONString(list));
    }


    @Test
    public void test_AjbJpaRepository(){
        List<Ajb> list = ajbService.findAll();
        System.out.println(JSON.toJSONString(list));
    }

    @Test
    public void test_AjbByAjlx(){
        List<Ajb> list = ajbService.findByAjlx("刑事案件");
        System.out.println(JSON.toJSONString(list));
    }

    @Test
    public void test_AjlxAndAjxz(){
        List<Ajb> list = ajbService.findByAjlxAndAjxz("刑事案件","盗窃");
        System.out.println(JSON.toJSONString(list));
    }

    @Test
    public void test_AjlxAndAjxzAndXzfl(){
        List<Ajb> list = ajbService.findByAjlxAndAjxzAndXzfl("刑事案件","盗窃","盗窃车内财物");
        System.out.println(JSON.toJSONString(list));
    }

    @Test
    public void test_AjlxAndAjxzAndXzflAndXzxl(){
        List<Ajb> list = ajbService.findByAjlxAndAjxzAndXzflAndXzxl("刑事案件","盗窃","盗窃车内财物","盗窃货车车内财物");
        System.out.println(JSON.toJSONString(list));
    }

}
    



