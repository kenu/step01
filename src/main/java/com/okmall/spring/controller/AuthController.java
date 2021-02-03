package com.okmall.spring.controller;

import com.okmall.spring.component.message.Messages;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/login")
@Controller
public class AuthController {
    @GetMapping
    public String loginForm() {
        return "auth/login";
    }

    @GetMapping(params = "error")
    public String loginError(Model model) {
        model.addAttribute(new Messages().error("Credentials is invalid"));
        return loginForm();
    }
}
