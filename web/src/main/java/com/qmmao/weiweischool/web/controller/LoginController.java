package com.qmmao.weiweischool.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author maoqi
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping({"/", "login"})
    public String login() {
        return "login/login";
    }
}
