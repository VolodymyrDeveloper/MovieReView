package com.cursor.lobo.moviereview.service;

import com.cursor.lobo.moviereview.comparator.MovieComparator;
import com.cursor.lobo.moviereview.dto.MovieDto;
import com.cursor.lobo.moviereview.dto.MovieDtoForList;
import com.cursor.lobo.moviereview.entity.Movie;
import com.cursor.lobo.moviereview.mapping.MovieDtoForListMapper;
import com.cursor.lobo.moviereview.mapping.MovieDtoMapper;
import com.cursor.lobo.moviereview.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursor.lobo.moviereview.entity.Rate;


import java.util.Objects;
import java.util.Optional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    @Autowired
    MovieDtoMapper movieDtoMapper;

    @Autowired
    MovieDtoForListMapper movieDtoForListMapper;

    private Optional<Movie> findById(Long id) {
        return movieRepository.findById(id);
    }

    public Movie addMovie(Movie movie) {
        if (Objects.nonNull(movie)) {
            return movieRepository.save(movie);
        } else {
            return null;
        }
    }

    public Movie deleteById(Long id) {
        Optional<Movie> optionalMovie = findById(id);
        if (optionalMovie.isPresent()) {
            movieRepository.deleteById(id);
        }
        return null;
    }

    public Movie updateMovieById(Long id, Movie movie) {
        Optional<Movie> optionalMovie = findById(id);
        if (optionalMovie.isPresent()) {
            Movie returnValue = new Movie();
            movie.setName(movie.getName());
            movie.setDirector(movie.getDirector());
            movie.setShortDescription(movie.getShortDescription());
            movie.setCategory(movie.getCategory());
            movie.setRateValue(movie.getRateValue());
            movie.setRate(movie.getRate());

            return movieRepository.save(movie);
        }
        return null;
    }

    public MovieDto getMovieWithAllInfoById(Long id) {
        Optional<Movie> optionalMovie = findById(id);
        if (optionalMovie.isPresent()) {
            return movieDtoMapper.convert(optionalMovie.get());
        }
        return null;
    }

    public Movie updateRate(Long id, Rate rate) {
        Optional<Movie> optionalMovie = findById(id);
        if (optionalMovie.isPresent()) {
            Movie returnMovie = optionalMovie.get();
            returnMovie.setRate(rate);
            return movieRepository.save(returnMovie);
        }
        return null;
    }

    public List<MovieDtoForList> returnListOfMovieWithCutInfo() {
        List<Movie> movieList = movieRepository.findAll();
        List<MovieDtoForList> returnList = movieList.stream().map(movie -> movieDtoForListMapper.convert(movie))
                .collect(Collectors.toList());
        return returnList;
    }

    public List<Movie> returnMoviesSortedByRateValue() {
        return movieRepository.findAll().stream().sorted(new MovieComparator()).collect(Collectors.toList());
    }
}
