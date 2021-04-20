package com.qmmao.weiweischool.auth.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author DELL
 */
@Controller
public class ViewController {

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping({"/home", "/", ""})
    public String home() {
        return "home";
    }
}
