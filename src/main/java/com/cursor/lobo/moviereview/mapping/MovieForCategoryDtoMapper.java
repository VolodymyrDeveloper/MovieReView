package com.cursor.lobo.moviereview.mapping;

import com.cursor.lobo.moviereview.dto.MovieForCategoryDto;
import com.cursor.lobo.moviereview.dto.ReviewDto;
import com.cursor.lobo.moviereview.entity.Movie;
import com.cursor.lobo.moviereview.entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class MovieForCategoryDtoMapper {
    @Autowired
    ReviewsDtoMapper reviewsDtoMapper;
    @Autowired
    RateDtoMapper rateDtoMapper;
    public MovieForCategoryDto convert(Movie movie) {
        Set<Review> reviews = movie.getReviews();
        Set<ReviewDto> dtos = new HashSet<>();
        for (Review temp : reviews) {
            dtos.add(reviewsDtoMapper.convert(temp));
        }
        return MovieForCategoryDto.builder()
                .id(movie.getId())
                .name(movie.getName())
                .director(movie.getDirector())
                .shortDescription(movie.getShortDescription())
                .reviewDtos(dtos)
                .rateDto(movie.getRateValue() == null ? null : rateDtoMapper.convert(movie.getRateValue()))
                .build();
    }
}
