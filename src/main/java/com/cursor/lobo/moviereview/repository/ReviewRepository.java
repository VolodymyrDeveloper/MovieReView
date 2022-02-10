package com.cursor.lobo.moviereview.repository;

import com.cursor.lobo.moviereview.entity.Movie;
import com.cursor.lobo.moviereview.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Set;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    Set<Review> findAllByMovie(Movie movie);
}
