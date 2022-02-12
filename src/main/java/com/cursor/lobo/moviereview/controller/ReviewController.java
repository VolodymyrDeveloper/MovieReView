package com.cursor.lobo.moviereview.controller;

import com.cursor.lobo.moviereview.entity.Review;
import com.cursor.lobo.moviereview.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    /*400
    HttpMessageNotReadableException: JSON parse error: Cannot deserialize value of type ... Review
    nested exception is MismatchedInputException: Cannot deserialize value of type ... Review
     */
    @PostMapping("/review")
    public ResponseEntity<Review> addReview(@RequestBody Review review) {
        Review returnValue = reviewService.addReview(review);
        return ResponseEntity.ok(returnValue);
    }
}
