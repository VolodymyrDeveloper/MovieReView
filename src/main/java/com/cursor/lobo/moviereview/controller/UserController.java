package com.cursor.lobo.moviereview.controller;

import com.cursor.lobo.moviereview.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.cursor.lobo.moviereview.entity.User;
import com.cursor.lobo.moviereview.entity.Review;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return userService.addUser(user) == null ? ResponseEntity.badRequest().build() :
                ResponseEntity.ok(userService.findById(user.getId()));
    }

    @PostMapping("/{userId}/add-review/{movieId}")
    public ResponseEntity<User> addReview(@PathVariable long userId,
                                          @PathVariable long movieId,
                                          @RequestBody Review review) {
        try {
            userService.addReview(userId, movieId, review);
            return ResponseEntity.ok().build();
        } catch (RuntimeException exception) {
            return ResponseEntity.notFound().build();
        }
    }
}
