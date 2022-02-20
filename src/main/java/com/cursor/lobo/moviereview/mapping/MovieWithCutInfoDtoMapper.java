package com.cursor.lobo.moviereview.mapping;

import com.cursor.lobo.moviereview.dto.MovieDto;
import com.cursor.lobo.moviereview.dto.MovieWithCutInfoDto;
import com.cursor.lobo.moviereview.entity.Category;
import com.cursor.lobo.moviereview.entity.Movie;
import com.cursor.lobo.moviereview.enums.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Component
public class MovieWithCutInfoDtoMapper {
    @Autowired
    RateDtoMapper rateDtoMapper;

    public MovieWithCutInfoDto convert(Movie movie) {
        Set<Category> categories = movie.getCategories();
        Set<String> genres = new HashSet<>();
        for (Category temp : categories) {
            genres.add(Genre.valueOf(temp.getGenre()).getGenre());
        }
        MovieWithCutInfoDto returnValue = new MovieWithCutInfoDto();
        returnValue.setId(movie.getId())
                .setName(movie.getName())
                .setGenres(genres)
                .setRateDto(null);

        if(Objects.nonNull(movie.getRateValue())) {
            returnValue.setRateDto(rateDtoMapper.convert(movie.getRateValue()));
        }

        return returnValue;
    }
}
