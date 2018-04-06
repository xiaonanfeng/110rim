package com.zxit.controller;

import com.zxit.model.CallinfoBb;
import com.zxit.service.CallinfoBbService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/callinfoBb")
public class CallinfoBbController {

    @Resource
    private CallinfoBbService callinfoBbService;

    /**
     * 通过接警单号查询录音集合
     *
     * @param eventid
     * @return
     */
    @RequestMapping(value = "/findCallinfoBbByEventid/{eventid}", method = RequestMethod.GET)
    public List<CallinfoBb> findCallinfoBbByEventid(@PathVariable String eventid) {
        List<CallinfoBb> list = callinfoBbService.findCallinfoBbByEventid(eventid);
        return list;
    }

    /**
     * 根据录音ID查询录音的http路径
     *
     * @param guid
     * @return
     */
    @RequestMapping(value = "findRecPathByEventId/{guid}",method = RequestMethod.GET)
    public String findRecPathByEventId(@PathVariable String guid) {
        String httpPath = callinfoBbService.findRecPathByEventId(guid);
        return httpPath;
    }
}
    



