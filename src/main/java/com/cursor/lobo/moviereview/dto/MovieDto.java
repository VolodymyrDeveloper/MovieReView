package com.cursor.lobo.moviereview.dto;

import com.cursor.lobo.moviereview.enums.Genre;
import com.cursor.lobo.moviereview.entity.Review;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@Builder
public class MovieDto {
    Long id;
    String name;
    String director;
    String shortDescription;
    Set<Genre> genre;
    double rateValue;
    Set<Review> reviews;
}
