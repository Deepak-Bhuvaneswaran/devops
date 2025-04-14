package com.example.inkinsight.inkinsight.controller;

import com.example.inkinsight.inkinsight.model.Review;
import com.example.inkinsight.inkinsight.model.User;
import com.example.inkinsight.inkinsight.service.ReviewService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DashboardController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        
        if (loggedInUser == null) {
            return "redirect:/login";
        }
        
        List<Review> userReviews = reviewService.findReviewsByUser(loggedInUser);
        model.addAttribute("reviews", userReviews);
        return "dashboard";
    }
}