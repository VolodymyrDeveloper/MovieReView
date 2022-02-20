package com.cursor.lobo.moviereview.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;


@Builder
@Getter
@Setter
public class ReviewDto {
    private long id;
    private String reviewMessage;
    private boolean isLiked;
    private UserDto userDto;
}
