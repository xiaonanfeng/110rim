package com.zxit.controller;

import com.zxit.model.Jjdwb;
import com.zxit.service.JjdwbService;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/jjdwb")
public class JjdwbController {


    @Resource
    private JjdwbService jjdwbService;

    @GetMapping("/findJjdwb/{sortStr}")
    public List<Jjdwb> findJjdwb(@PathVariable String sortStr) {
        Sort sort = new Sort(Sort.Direction.ASC, sortStr);
        List<Jjdwb> list = jjdwbService.findAll(sort);
        return list;
    }

}
    



