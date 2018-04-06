package com.zxit.controller;


import com.zxit.model.Ajb;
import com.zxit.service.AjbService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/ajb")
public class AjbController {

    @Resource
    private AjbService ajbService;

    @GetMapping(value = "/findAjlx")
    public List<String> findAjlx() {
        List<String> list = ajbService.findAjlx();
        return list;
    }

    @GetMapping(value = "/findByAjlx/{ajlx}")
    public List<Ajb> findByAjlx(@PathVariable String ajlx) {
        List<Ajb> list = ajbService.findByAjlx(ajlx);
        return list;
    }

    @GetMapping(value = "/findByAjlxAndAjxz/{ajlx}/{ajxz}")
    public List<Ajb> findByAjlxAndAjxz(@PathVariable String ajlx, @PathVariable String ajxz) {
        List<Ajb> list = ajbService.findByAjlxAndAjxz(ajlx, ajxz);
        return list;
    }

    @GetMapping(value = "/findByAjlxAndAjxzAndXzfl/{ajlx}/{ajxz}/{xzfl}")
    public List<Ajb> findByAjlxAndAjxzAndXzfl(@PathVariable String ajlx, @PathVariable String ajxz, @PathVariable String xzfl) {
        List<Ajb> list = ajbService.findByAjlxAndAjxzAndXzfl(ajlx, ajxz, xzfl);
        return list;
    }

    @GetMapping(value = "/findByAjlxAndAjxzAndXzflAndXzxl/{ajlx}/{ajxz}/{xzfl}/{xzxl}")
    public List<Ajb> findByAjlxAndAjxzAndXzflAndXzxl(@PathVariable String ajlx, @PathVariable String ajxz, @PathVariable String xzfl, @PathVariable String xzxl) {
        List<Ajb> list = ajbService.findByAjlxAndAjxzAndXzflAndXzxl(ajlx, ajxz, xzfl, xzxl);
        return list;
    }
}
    



