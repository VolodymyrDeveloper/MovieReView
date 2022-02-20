package com.cursor.lobo.moviereview.mapping;

import com.cursor.lobo.moviereview.dto.UserDto;
import com.cursor.lobo.moviereview.entity.User;
import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

@Component
public class UserDtoMapper extends AbstractConverter<User, UserDto> {
    @Override
    protected UserDto convert(User user) {
        return UserDto.builder()
                .id(user.getId())
                .login(user.getLogin())
                .build();
    }
}
