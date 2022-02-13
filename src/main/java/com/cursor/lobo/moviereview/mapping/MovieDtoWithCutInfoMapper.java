package com.cursor.lobo.moviereview.mapping;

import com.cursor.lobo.moviereview.entity.Movie;
import com.cursor.lobo.moviereview.dto.MovieDtoWithCutInfo;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class MovieDtoWithCutInfoMapper {

    public MovieDtoWithCutInfo convert(Movie movie) {
        return MovieDtoWithCutInfo.builder()
                .name(movie.getName())
                .categories(movie.getCategory())
                .rateValue(movie.getRateValue())
                .build();
    }
}
