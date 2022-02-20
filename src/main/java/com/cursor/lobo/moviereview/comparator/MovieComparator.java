package com.cursor.lobo.moviereview.comparator;

import com.cursor.lobo.moviereview.dto.MovieWithCutInfoDto;
import com.cursor.lobo.moviereview.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Comparator;


public class MovieComparator implements Comparator<MovieWithCutInfoDto>{
    @Autowired
    RateDtoComparator rateDtoComparator;

    @Override
    public int compare(MovieWithCutInfoDto o1, MovieWithCutInfoDto o2) {
        return rateDtoComparator.compare(o1.getRateDto(), o2.getRateDto());
    }
}
