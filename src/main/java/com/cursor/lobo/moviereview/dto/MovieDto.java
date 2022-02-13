package com.cursor.lobo.moviereview.dto;

import com.cursor.lobo.moviereview.entity.Category;
import com.cursor.lobo.moviereview.entity.Rate;
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
    Set<Category> categories;
    Rate rateValue;
    Set<Review> reviews;
}
