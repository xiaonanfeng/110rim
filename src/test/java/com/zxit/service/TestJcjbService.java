package com.zxit.service;

import com.alibaba.fastjson.JSON;
import com.zxit.model.Jcjb;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestJcjbService {

    @Resource
    private JcjbService jcjbService;

    @Test
    public void findJcjbs() {
        Sort sort = new Sort(Sort.Direction.DESC, "guid");
        Pageable pageable = new PageRequest(0, 100, sort);
        Jcjb jcjb = new Jcjb();
//        jcjb.setAjlx("刑事案件");
//        jcjb.setAjxz("盗窃");
//        jcjb.setXzfl("盗窃非机动车");
//        jcjb.setXzxl("盗窃自行车");
//        jcjb.setZby("王莉");
        jcjb.setBjdh("13525030132");
//        jcjb.setBjrxm("薰学广");
//        jcjb.setFadz("封丘县城关镇人民医院车棚");
//        jcjb.setAjrz("值班员:张晓于");
        Page<Jcjb> page = jcjbService.findJcjbs(pageable, jcjb);
        System.out.println(page.getTotalPages());
        System.out.println(JSON.toJSONString(page));
    }

    @Test
    public void findJcjbs2() {
        Jcjb jcjb = new Jcjb();
        jcjb.setJjh("2013122706100000001");
//        jcjb.setAjlx("刑事案件");
//        jcjb.setAjxz("盗窃");
//        jcjb.setXzfl("盗窃非机动车");
//        jcjb.setXzxl("盗窃自行车");
//        jcjb.setZby("王莉");
//        jcjb.setBjdh("135");
//        jcjb.setBjrxm("薰学广");
//        jcjb.setFadz("封丘县城关镇人民医院车棚");
//        jcjb.setAjrz("值班员:张晓于");
//        Calendar c = Calendar.getInstance();
//        c.setTime(new Date());
//        c.add(Calendar.YEAR, -1);
//        Date lastYear = c.getTime();
//        jcjb.setBjsjStart(lastYear);
//        jcjb.setBjsjEnd(new Date());
        Sort sort = new Sort(Sort.Direction.DESC, "jjh");
        List<Jcjb> list = jcjbService.findJcjbs(sort, jcjb);
        System.out.println(JSON.toJSONString(list));
    }

    @Test
    public void findOneJcjb() {
        Jcjb jcjb = jcjbService.findByJjh("2013123106100000049");
        System.out.println(JSON.toJSONString(jcjb));
    }

}
    



