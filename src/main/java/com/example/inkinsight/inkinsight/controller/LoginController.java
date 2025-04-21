package com.example.inkinsight.inkinsight.controller;

import com.example.inkinsight.inkinsight.model.Login;
import com.example.inkinsight.inkinsight.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login-old")
    public String processLogin(@RequestParam String username, 
                               @RequestParam String password, 
                               Model model) {
        Login user = loginService.log(username, password);
        if (user != null) {
            return "redirect:/welcome";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }

    @GetMapping("/welcome")
    public String showWelcomePage() {
        return "welcome";
    }
}