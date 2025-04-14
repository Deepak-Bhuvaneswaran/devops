package com.example.inkinsight.inkinsight.controller;

import com.example.inkinsight.inkinsight.model.User;
import com.example.inkinsight.inkinsight.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {
    @Autowired
    private UserService userService;

    @GetMapping("/signup")
    public String signupForm(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute User user, Model model) {
        if (userService.emailExists(user.getEmail())) {
            model.addAttribute("message", "Account already exists");
            return "signup";
        }
        userService.saveUser(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user, HttpSession session, Model model) {
        return userService.authenticate(user.getEmail(), user.getPassword())
                .map(u -> {
                    session.setAttribute("loggedInUser", u);
                    return "redirect:/dashboard";
                }).orElseGet(() -> {
                    model.addAttribute("message", "Invalid credentials");
                    return "login";
                });
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}