package com.cursor.lobo.moviereview.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CategoryDto {
    long id;
    String genre;
}
