package com.cursor.lobo.moviereview.mapping;

import com.cursor.lobo.moviereview.entity.Movie;
import com.cursor.lobo.moviereview.dto.MovieDto;
import com.cursor.lobo.moviereview.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class MovieDtoMapper {
    @Autowired
    ReviewRepository reviewRepository;

    public MovieDto convert(Movie movie) {
        return MovieDto.builder()
                .id(movie.getId())
                .name(movie.getName())
                .director(movie.getDirector())
                .rateValue(movie.getRateValue())
                .shortDescription(movie.getShortDescription())
                .genre(movie.getCategory().stream().map(category -> category.getGenre()).collect(Collectors.toSet()))
                .reviews(reviewRepository.findAllByMovie(movie))
                .build();
    }
}
