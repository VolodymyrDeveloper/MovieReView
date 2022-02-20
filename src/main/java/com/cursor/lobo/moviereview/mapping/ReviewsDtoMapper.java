package com.cursor.lobo.moviereview.mapping;

import org.modelmapper.AbstractConverter;
import com.cursor.lobo.moviereview.entity.Review;
import com.cursor.lobo.moviereview.dto.ReviewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReviewsDtoMapper extends AbstractConverter<Review, ReviewDto> {
    @Autowired
    UserDtoMapper userDtoMapper;

    @Override
    protected ReviewDto convert(Review review) {
        return ReviewDto.builder()
                .id(review.getId())
                .reviewMessage(review.getReviewMessage())
                .isLiked(review.getIsLiked())
                .userDto(userDtoMapper.convert(review.getUser()))
                .build();
    }
}
