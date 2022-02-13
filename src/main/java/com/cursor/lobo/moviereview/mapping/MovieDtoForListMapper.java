package com.cursor.lobo.moviereview.mapping;

import com.cursor.lobo.moviereview.entity.Movie;
import com.cursor.lobo.moviereview.dto.MovieDtoWIthCutInfo;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class MovieDtoForListMapper {

    public MovieDtoWIthCutInfo convert(Movie movie) {
        return MovieDtoWIthCutInfo.builder()
                .name(movie.getName())
                .genres(movie.getCategory().stream().map(category -> category.getGenre()).collect(Collectors.toSet()))
                .rating(movie.getRate())
                .build();
    }
}
