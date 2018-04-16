package com.zxit.controller;

import com.alibaba.fastjson.JSONArray;
import com.zxit.config.YmlConfig;
import com.zxit.model.CallinfoBb;
import com.zxit.model.Jcjb;
import com.zxit.service.CallinfoBbService;
import com.zxit.service.JcjbService;
import com.zxit.service.TransWav2Mp3Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/jcjb")
public class JcjbController {

    @Resource
    private JcjbService jcjbService;
    @Resource
    private CallinfoBbService callinfoBbService;
    @Resource
    private TransWav2Mp3Service transWav2Mp3Service;
    @Resource
    private YmlConfig ymlConfig;

    private static final String sourceRootPath = "Z:/";
    private static final String tarRootPath = "/java/resources/";


    @PostMapping("/testMw")
    public void testMw(@RequestBody JSONArray jsonArray) {
        System.out.println(jsonArray);
    }

    /**
     * 带分页的查询接处警信息
     *
     * @param page
     * @param size
     * @param jcjb
     * @return
     */
    @PostMapping("/findPagerByJcjb/{page}/{size}")
    public Page<Jcjb> findPagerByJcjb(@PathVariable Integer page, @PathVariable Integer size, @RequestBody Jcjb jcjb) {
        Sort sort = new Sort(Sort.Direction.DESC, "jjh");
        Pageable pageable = new PageRequest(page, size, sort);
        Page<Jcjb> pageJcjb = jcjbService.findJcjbs(pageable, jcjb);
        return pageJcjb;
    }


    /**
     * 根据条件查询接处警信息
     *
     * @param jcjb
     * @return
     */
    @PostMapping("/findJcjbs")
    public List<Jcjb> findJcjbs(@RequestBody Jcjb jcjb) {
        Sort sort = new Sort(Sort.Direction.DESC, "jjh");
        return jcjbService.findJcjbs(sort, jcjb);
    }

    /**
     * 查询接处警信息对象
     *
     * @param jjh
     * @return
     */
    @GetMapping("/findJcjbByJjh/{jjh}")
    public Jcjb findJcjbByJjh(@PathVariable String jjh) {
        return jcjbService.findByJjh(jjh);
    }

    /**
     * 查询接处警信息对象
     *
     * @param jjh
     * @return
     */
    @GetMapping("/findJcjbByJjh2Word/{jjh}")
    public String findJcjbByJjh2Word(@PathVariable String jjh) {
        return jcjbService.findJcjbByJjh2Word(jjh);
    }


    /**
     * 通过接警流水号查询录音http路径集合
     *
     * @param jjh
     * @return
     */
    @GetMapping("/findMp3HttpPathByJjh/{jjh}")
    public List<String> findMp3HttpPathByJjh(@PathVariable String jjh) {
        //录音路径
        List<String> mp3Srcs = new ArrayList<>();
        //通过guid找到录音的callId
        List<CallinfoBb> callinfoBbs = callinfoBbService.findCallinfoBbByEventid(jjh);
        for (CallinfoBb d : callinfoBbs) {
            String callId = d.getCallid();
            //通过callId生成录音物理路径
            String diskPath = callId.substring(0, 8);
            String fileName = callId.substring(8, 14) + ".wav";
            //合成网络磁盘Z：下的屋里路径
            String netDisk = sourceRootPath + diskPath + "/" + fileName;
            String uuid = UUID.randomUUID().toString();
            try {
                transWav2Mp3Service.copyWavIntoDesk(netDisk, tarRootPath + uuid + ".wav");
            } catch (IOException e) {
                mp3Srcs.add("找不到录音源文件！");
                return mp3Srcs;
            }
            String map3HttpPath = ymlConfig.getServerIp() + uuid + ".wav";
            mp3Srcs.add(map3HttpPath);
        }
        //得到Mp3的Http路径
        return mp3Srcs;
    }

}
    



