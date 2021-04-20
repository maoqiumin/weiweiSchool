package com.qmmao.weiweischool.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author maoqi
 */
@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping("index")
    public String index(){

        return "home/index";
    }
}
