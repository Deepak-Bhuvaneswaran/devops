package com.example.inkinsight.inkinsight.repository;

import com.example.inkinsight.inkinsight.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}