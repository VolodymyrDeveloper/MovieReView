package com.cursor.lobo.moviereview.mapping;

import com.cursor.lobo.moviereview.dto.RateDto;
import com.cursor.lobo.moviereview.entity.Rate;
import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

@Component
public class RateDtoMapper extends AbstractConverter<Rate, RateDto> {
    @Override
    protected RateDto convert(Rate rate) {
        return RateDto.builder()
                .id(rate.getId())
                .rateValue(rate.getRateValue())
                .countOfVotes(rate.getCountOfVotes())
                .build();
    }
}
