package com.cursor.lobo.moviereview.comparator;

import com.cursor.lobo.moviereview.dto.RateDto;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

import java.util.Comparator;


@Component
public class RateDtoComparator implements Comparator<RateDto> {
    @Override
    public int compare(RateDto o1, RateDto o2) {
        return o1.getRateValue().compareTo(o2.getRateValue());
    }

}
