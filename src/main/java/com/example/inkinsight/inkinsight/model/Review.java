package com.example.inkinsight.inkinsight.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bookTitle;
    private String reviewerName;
    private String reviewContent;
    private int rating;

    // If Lombok is not properly configured, manually add the getter
    // public String getReviewerName() {
    //     return reviewerName;
    // }
}