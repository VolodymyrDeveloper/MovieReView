package com.cursor.lobo.moviereview.service;

import com.cursor.lobo.moviereview.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cursor.lobo.moviereview.entity.Review;

import java.util.Objects;

@Service
public class ReviewService {
    @Autowired
    ReviewRepository reviewRepository;

    public Review addReview(Review review) {
        if (Objects.nonNull(review)) {
            return reviewRepository.save(review);
        }
        return null;
    }

}
