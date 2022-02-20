package com.cursor.lobo.moviereview.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.Set;

@Builder
@Getter
public class CategoryWithMovieListDto {
    Set<MovieForCategoryDto> movies;
}
