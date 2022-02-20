package com.cursor.lobo.moviereview.service;

import com.cursor.lobo.moviereview.entity.Movie;
import com.cursor.lobo.moviereview.entity.Review;
import com.cursor.lobo.moviereview.repository.MovieRepository;
import com.cursor.lobo.moviereview.repository.ReviewRepository;
import com.cursor.lobo.moviereview.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cursor.lobo.moviereview.entity.User;

import java.util.Objects;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    MovieService movieService;

    public User addUser(User user) {
        if (Objects.nonNull(user)) {
            return userRepository.save(user);
        }
        return null;
    }

    public User findById(long id) {
        if (userRepository.findById(id).isPresent()) {
            return userRepository.findById(id).get();
        }
        return null;
    }

    public void addReview(long userId, long movieId, Review review) {
        User user = findById(userId);
        Movie movie = movieService.findById(movieId);
        if (Objects.nonNull(user) && Objects.nonNull(movie)) {
            user.addReview(movie, review);
            reviewRepository.save(review);
        } else {
            throw new RuntimeException();
        }
    }
}
