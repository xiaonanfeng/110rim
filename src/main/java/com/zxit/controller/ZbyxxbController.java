package com.zxit.controller;

import com.zxit.model.Zbyxxb;
import com.zxit.service.ZbyxxbService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/zbyxxb")
public class ZbyxxbController {

    @Resource
    private ZbyxxbService zbyxxbService;

    @GetMapping(value = "/{id}/{mm}")
    public Zbyxxb findZbyxxbByIdAndMm(@PathVariable String id, @PathVariable String mm) {
        Zbyxxb zbyxxb = zbyxxbService.findZbyxxbByIdAndMm(id, mm);
        return zbyxxb;
    }

    @GetMapping(value = "/findAll")
    public List<Zbyxxb> findAll() {
        List<Zbyxxb> list = zbyxxbService.findAll();
        return list;
    }

}
    



