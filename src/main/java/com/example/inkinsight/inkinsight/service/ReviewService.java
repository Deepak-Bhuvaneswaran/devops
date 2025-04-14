package com.example.inkinsight.inkinsight.service;

import com.example.inkinsight.inkinsight.model.Review;
import com.example.inkinsight.inkinsight.model.User;
import com.example.inkinsight.inkinsight.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public void saveReview(Review review) {
        reviewRepository.save(review);
    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public List<Review> findReviewsByUser(User loggedInUser) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findReviewsByUser'");
    }
}