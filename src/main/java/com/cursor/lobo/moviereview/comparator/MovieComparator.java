package com.cursor.lobo.moviereview.comparator;

import com.cursor.lobo.moviereview.entity.Movie;
import java.util.Comparator;
public class MovieComparator implements Comparator<Movie>{

    @Override
    public int compare(Movie o1, Movie o2) {
        return o1.getRateValue().compareTo(o2.getRateValue());
    }
}
