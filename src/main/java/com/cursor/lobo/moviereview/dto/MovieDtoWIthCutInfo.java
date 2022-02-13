package com.cursor.lobo.moviereview.dto;

import com.cursor.lobo.moviereview.entity.Rate;
import com.cursor.lobo.moviereview.enums.Genre;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

//@Component
@Setter
@Getter
@Builder
public class MovieDtoWIthCutInfo {
    String name;
    Set<Genre> genres;
    Rate rating;
}
