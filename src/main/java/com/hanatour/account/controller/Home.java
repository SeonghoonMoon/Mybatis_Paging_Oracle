package com.hanatour.account.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/html")
public class Home {
    @GetMapping({"/", "/home"})
    public String doHome() {
    return "/html/home";
    }
}
