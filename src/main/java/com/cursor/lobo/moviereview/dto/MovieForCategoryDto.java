package com.cursor.lobo.moviereview.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Set;

@Builder
@Getter
@Accessors(chain = true)
public class MovieForCategoryDto {
    private long id;
    private String name;
    private String director;
    private String shortDescription;
    private RateDto rateDto;
    private Set<ReviewDto> reviewDtos;
}
