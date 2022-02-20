package com.cursor.lobo.moviereview.comparator;

import com.cursor.lobo.moviereview.dto.MovieWithCutInfoDto;

import java.util.Comparator;

public class MovieByIdComparator implements Comparator<MovieWithCutInfoDto> {
    @Override
    public int compare(MovieWithCutInfoDto o1, MovieWithCutInfoDto o2) {
        return o1.getId().compareTo(o2.getId());
    }
}
