package com.cursor.lobo.moviereview.service;

import com.cursor.lobo.moviereview.dto.MovieDto;
import com.cursor.lobo.moviereview.dto.MovieUpdateDto;
import com.cursor.lobo.moviereview.dto.MovieWithCutInfoDto;
import com.cursor.lobo.moviereview.entity.Category;
import com.cursor.lobo.moviereview.entity.Movie;
import com.cursor.lobo.moviereview.entity.Rate;
import com.cursor.lobo.moviereview.mapping.MovieDtoMapper;
import com.cursor.lobo.moviereview.mapping.MovieWithCutInfoDtoMapper;
import com.cursor.lobo.moviereview.repository.CategoryRepository;
import com.cursor.lobo.moviereview.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


import java.util.Objects;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    MovieDtoMapper movieDtoMapper;
    @Autowired
    MovieWithCutInfoDtoMapper movieWithCutInfoDtoMapper;

    public Movie addMovie(Movie movie) {
        if (Objects.nonNull(movie)) {
            return movieRepository.save(movie);
        }
        return null;
    }

    public Movie findById(long id) {
        if (movieRepository.findById(id).isPresent()) {
            return movieRepository.findById(id).get();
        }
        return null;
    }

    public void removeMovieById(long id) {
        Movie deleteMovie = findById(id);
        if (Objects.nonNull(deleteMovie)) {
            movieRepository.deleteById(id);
        } else {
            throw new RuntimeException("There is no movie with such id");
        }
    }

    public Movie updateMovieById(Long id, MovieUpdateDto movie) {
        Movie updateMovie = findById(id);
        if (Objects.nonNull(updateMovie)) {
            updateMovie.setId(id);
            updateMovie.setName(movie.getName());
            updateMovie.setDirector(movie.getDirector());
            updateMovie.setShortDescription(movie.getShortDescription());
            return movieRepository.save(updateMovie);
        }
        return null;
    }

    public Movie setRateValue(long id, Rate rate) {
        Movie updateMovie = findById(id);
        if (Objects.nonNull(updateMovie)) {
            rate.setMovie(updateMovie);
            updateMovie.setRateValue(rate);
            return movieRepository.save(updateMovie);
        }
        return null;
    }

    public void addCategory(long movieId, long categoryId) {
        Movie updateMovie = findById(movieId);
        Optional<Category> category = categoryRepository.findById(categoryId);
        if (Objects.nonNull(updateMovie) && category.isPresent()) {
            Category getCategory = category.get();
            updateMovie.addCategory(getCategory);
            movieRepository.save(updateMovie);
        } else {
            throw new RuntimeException();
        }
    }

    public MovieDto returnMovieWithAllInfo(long id) {
        Movie movie = findById(id);
        if (Objects.nonNull(movie)) {
            return movieDtoMapper.convert(movie);
        }
        return null;
    }

    public List<MovieWithCutInfoDto> getAllMoviesWithCutInfo() {
        List<Movie> movies = movieRepository.findAll();
        List<MovieWithCutInfoDto> moviesWithCutInfo = new ArrayList<>();
        for (Movie temp : movies) {
            moviesWithCutInfo.add(movieWithCutInfoDtoMapper.convert(temp));
        }
        return moviesWithCutInfo;
    }
}
