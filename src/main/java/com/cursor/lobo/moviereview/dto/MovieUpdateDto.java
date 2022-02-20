package com.cursor.lobo.moviereview.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieUpdateDto {
    private long id;
    private String name;
    private String director;
    private String shortDescription;
}
