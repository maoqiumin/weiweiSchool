package com.qmmao.web.apicontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author maoqi
 */
@RestController
public class HomeApiController {
    @RequestMapping("/index1")
    public String index() {
        return "/home/index";
    } 
}
