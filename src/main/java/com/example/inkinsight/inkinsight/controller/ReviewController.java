package com.example.inkinsight.inkinsight.controller;

import com.example.inkinsight.inkinsight.model.Review;
import com.example.inkinsight.inkinsight.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewRepository reviewRepository;

    @GetMapping("/add")
    public String showAddReviewForm(Model model) {
        model.addAttribute("review", new Review());
        return "add-review";
    }

    @PostMapping("/add")
    public String submitReview(@ModelAttribute Review review) {
        reviewRepository.save(review);
        return "redirect:/reviews/list";
    }

    @GetMapping("/list")
    public String listReviews(Model model) {
        model.addAttribute("reviews", reviewRepository.findAll());
        return "review-list";
    }
}