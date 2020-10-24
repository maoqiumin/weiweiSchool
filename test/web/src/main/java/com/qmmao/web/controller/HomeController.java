package com.qmmao.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author maoqi
 */
@RestController
public class HomeController {
    @RequestMapping("/index")
    public String index() {
        return "/home/index";
    } 
}
