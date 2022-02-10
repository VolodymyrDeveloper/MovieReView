package com.cursor.lobo.moviereview.mapping;

import com.cursor.lobo.moviereview.entity.Movie;
import com.cursor.lobo.moviereview.dto.MovieDtoForList;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class MovieDtoForListMapper {

    public MovieDtoForList convert(Movie movie) {
        return MovieDtoForList.builder()
                .name(movie.getName())
                .genres(movie.getCategory().stream().map(category -> category.getGenre()).collect(Collectors.toSet()))
                .rating(movie.getRate())
                .build();
    }
}
