package com.zxl.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuickController {
    @RequestMapping("/helloworld")
    public String quick(){
        return "hello world!!!";
    }
}
