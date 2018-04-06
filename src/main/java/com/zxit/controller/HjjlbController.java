package com.zxit.controller;

import com.zxit.model.Hjjlb;
import com.zxit.model.dto.CountDto;
import com.zxit.service.HjjlbService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/hjjlb")
public class HjjlbController {

    @Resource
    private HjjlbService hjjlbService;


    @PostMapping("/findLdsjBetweenGroupByHjzt")
    public List<CountDto> findLdsjBetweenGroupByHjzt(@RequestBody Hjjlb hjjlb) {
        Date ldsjStrat = hjjlb.getLdsjStart();
        Date ldsjEnd = hjjlb.getLdsjEnd();
        List<CountDto> list = hjjlbService.findLdsjBetweenGroupByHjzt(ldsjStrat,ldsjEnd);
        return list;
    }



    @PostMapping("/findLdsjBetweenGroupByBjhm")
    public List<CountDto> findLdsjBetweenGroupByBjhm(@RequestBody Hjjlb hjjlb) {
        Date ldsjStrat = hjjlb.getLdsjStart();
        Date ldsjEnd = hjjlb.getLdsjEnd();
        List<CountDto> list = hjjlbService.findLdsjBetweenGroupByBjhm(ldsjStrat,ldsjEnd);
        return list;
    }


}
    



