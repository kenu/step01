package com.okmall.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/login")
@Controller
public class AuthController {
    @GetMapping
    public String loginForm() {
        return "auth/login";
    }

}
