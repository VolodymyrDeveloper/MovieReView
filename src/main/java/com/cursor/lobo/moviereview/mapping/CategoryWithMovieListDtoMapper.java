package com.cursor.lobo.moviereview.mapping;

import com.cursor.lobo.moviereview.dto.CategoryWithMovieListDto;
import com.cursor.lobo.moviereview.dto.MovieForCategoryDto;
import com.cursor.lobo.moviereview.entity.Category;
import com.cursor.lobo.moviereview.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class CategoryWithMovieListDtoMapper {
    @Autowired
    MovieForCategoryDtoMapper movieForCategoryDtoMapper;
    public CategoryWithMovieListDto convert(Category category) {
        Set<Movie> movies = category.getMovies();
        Set<MovieForCategoryDto> convertMovies = new HashSet<>();

        for (Movie temp : movies) {
            convertMovies.add(movieForCategoryDtoMapper.convert(temp));
        }
        return CategoryWithMovieListDto.builder()
                .movies(convertMovies)
                .build();
    }
}
