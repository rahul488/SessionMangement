package com.example.Login.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login(@RequestParam(value = "invalid",defaultValue = "false")boolean invalid, HttpSession session){
        if(invalid)
            session.setAttribute("invalidSession","You already have an active session..");

        return "login";
    }
}
