package com.smalltalk.hyb.spring.boot.pro.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aspect")
public class AspectController {


    @RequestMapping("point")
    public String point() {
        return "ascpect point";
    }
}
