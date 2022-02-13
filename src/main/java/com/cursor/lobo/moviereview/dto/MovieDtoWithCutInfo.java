package com.cursor.lobo.moviereview.dto;

import com.cursor.lobo.moviereview.entity.Category;
import com.cursor.lobo.moviereview.entity.Rate;
import com.cursor.lobo.moviereview.enums.Genre;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@Builder
public class MovieDtoWithCutInfo {
    String name;
    Set<Category> categories;
    Rate rateValue;
}
