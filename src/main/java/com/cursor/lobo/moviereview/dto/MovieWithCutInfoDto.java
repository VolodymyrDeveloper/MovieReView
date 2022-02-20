package com.cursor.lobo.moviereview.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class MovieWithCutInfoDto {
    private Long id;
    private String name;
    private Set<String> genres;
    private RateDto rateDto;
}
