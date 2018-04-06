package com.zxit.service;

import com.zxit.model.Hjjlb;
import com.zxit.model.dto.CountDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestHjjlbService {

    @Resource
    private HjjlbService hjjlbService;



    @Test
    public void test_findLdsjBetweenGroupByHjzt(){
        Hjjlb hjjlb = new Hjjlb();
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.YEAR, -1);
        Date lastYear = c.getTime();
        hjjlb.setLdsjStart(lastYear);
        hjjlb.setLdsjEnd(new Date());
        List<CountDto> list = hjjlbService.findLdsjBetweenGroupByHjzt(lastYear,new Date());
        System.out.println(list.size());
    }


    @Test
    public void findLdsjBetweenGroupByBjhm(){
        Hjjlb hjjlb = new Hjjlb();
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.YEAR, -1);
        Date lastYear = c.getTime();
        hjjlb.setLdsjStart(lastYear);
        hjjlb.setLdsjEnd(new Date());
        List<CountDto> list = hjjlbService.findLdsjBetweenGroupByBjhm(lastYear,new Date());
        System.out.println(list.size());
    }

}
    



