package com.cursor.lobo.moviereview.dto;

import java.util.Set;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;


@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class MovieDto {
    private long id;
    private String name;
    private String director;
    private String shortDescription;
    private RateDto rateDto;
    private Set<String> genres;
    private Set<ReviewDto> reviewDtos;

}
