package com.cursor.lobo.moviereview.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UserDto {
    private long id;
    private String login;
}
