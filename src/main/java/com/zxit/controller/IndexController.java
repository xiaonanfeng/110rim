package com.zxit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class IndexController {


    @RequestMapping(value = "/word")
    public String word() {
        return "/word";
    }

}
    



