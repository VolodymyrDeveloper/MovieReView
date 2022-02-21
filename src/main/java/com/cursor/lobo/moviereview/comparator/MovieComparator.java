package com.cursor.lobo.moviereview.comparator;

import com.cursor.lobo.moviereview.dto.MovieWithCutInfoDto;
import com.cursor.lobo.moviereview.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Comparator;


public class MovieComparator implements Comparator<MovieWithCutInfoDto>{

    @Override
    public int compare(MovieWithCutInfoDto o1, MovieWithCutInfoDto o2) {
        return o1.getRateDto().getRateValue().compareTo(o2.getRateDto().getRateValue());
    }
}
