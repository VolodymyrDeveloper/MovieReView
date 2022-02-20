package com.cursor.lobo.moviereview.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class RateDto {
    private long id;
    private Double rateValue;
    private int countOfVotes;
}
