package com.zking.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("Test")
public class TestController {

    @RequestMapping("test")
    public String test(){

        return "forward:/test/hello";
    }




    @RequestMapping("News")
    public String News(){
        return "News";
    }

}
