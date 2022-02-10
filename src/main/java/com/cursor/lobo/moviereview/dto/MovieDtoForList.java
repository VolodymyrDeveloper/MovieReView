package com.cursor.lobo.moviereview.dto;

import com.cursor.lobo.moviereview.entity.Rate;
import com.cursor.lobo.moviereview.enums.Genre;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import java.util.Set;

@Component
@Setter
@Getter
@Builder
public class MovieDtoForList {
    String name;
    Set<Genre> genres;
    Rate rating;
}
