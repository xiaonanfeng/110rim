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
public class TestTransWav2Mp3Service {

    @Resource
    private TransWav2Mp3Service transWav2Mp3Service;

    @Resource
    private CallinfoBbService callinfoBbService;

    @Test
    public void test_TransWav2Mp3(){

        List<CallinfoBb> list = callinfoBbService.findCallinfoBbByEventid("2017062706100000171");
        System.out.println(JSON.toJSONString(list));

//        transWav2Mp3Service.copyWavIntoDesk();

    }


    @Test
    public void test_transWav2Mp3(){
        String src = "d:/02_Escape From The Fade.wav";
        String tar = "d:/02_Escape From The Fade.mp3";
        try {
            transWav2Mp3Service.transWav2Mp3(src,tar);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
    



