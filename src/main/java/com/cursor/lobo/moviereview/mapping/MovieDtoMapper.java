package com.cursor.lobo.moviereview.mapping;

import com.cursor.lobo.moviereview.dto.MovieDto;
import com.cursor.lobo.moviereview.dto.ReviewDto;
import com.cursor.lobo.moviereview.entity.Category;
import com.cursor.lobo.moviereview.entity.Movie;
import com.cursor.lobo.moviereview.entity.Review;
import com.cursor.lobo.moviereview.enums.Genre;
import org.modelmapper.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Component
public class MovieDtoMapper {
    @Autowired
    RateDtoMapper rateDtoMapper;
    @Autowired
    ReviewsDtoMapper reviewsDtoMapper;

    public MovieDto convert(Movie movie) {

        Set<Category> categories = movie.getCategories();
        Set<String> genres = new HashSet<>();
        for (Category temp : categories) {
            genres.add(Genre.valueOf(temp.getGenre()).getGenre());
        }

        Set<Review> reviews = movie.getReviews();
        Set<ReviewDto> dtos = new HashSet<>();
        for (Review temp : reviews) {
            dtos.add(reviewsDtoMapper.convert(temp));
        }
        MovieDto returnValue = new MovieDto();
        returnValue.setId(movie.getId())
                .setName(movie.getName())
                .setDirector(movie.getDirector())
                .setShortDescription(movie.getShortDescription())
                .setGenres(genres)
                .setRateDto(null)
                .setReviewDtos(dtos);

        if(Objects.nonNull(movie.getRateValue())) {
            returnValue.setRateDto(rateDtoMapper.convert(movie.getRateValue()));
        }

        return returnValue;
    }
}
