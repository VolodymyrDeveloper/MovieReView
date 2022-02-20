package com.cursor.lobo.moviereview.controller;

import com.cursor.lobo.moviereview.comparator.MovieByIdComparator;
import com.cursor.lobo.moviereview.comparator.MovieComparator;
import com.cursor.lobo.moviereview.dto.MovieUpdateDto;
import com.cursor.lobo.moviereview.dto.MovieWithCutInfoDto;
import com.cursor.lobo.moviereview.entity.Movie;
import com.cursor.lobo.moviereview.mapping.MovieDtoMapper;
import com.cursor.lobo.moviereview.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.cursor.lobo.moviereview.dto.MovieDto;
import com.cursor.lobo.moviereview.entity.Rate;
import java.util.List;

import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @Autowired
    MovieDtoMapper movieDtoMapper;

    @PostMapping("/add")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        return movieService.addMovie(movie) == null ? ResponseEntity.badRequest().build() :
                ResponseEntity.ok(movieService.findById(movie.getId()));
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Movie> removeMovieById(@PathVariable long id) {
        try {
            movieService.removeMovieById(id);
            return ResponseEntity.ok().build();
        } catch(RuntimeException exception) {
            return ResponseEntity.notFound().build();
        }
    }

    /*
        Can update entity, but until it has category or reviews
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable long id, @RequestBody MovieUpdateDto movie) {
        return movieService.updateMovieById(id, movie) == null ? ResponseEntity.notFound().build() :
                ResponseEntity.ok(movieService.findById(id));

    }

    @PostMapping("/{id}/add-rate")
    public ResponseEntity<Movie> addRate(@PathVariable long id, @RequestBody Rate rate) {
        return movieService.setRateValue(id, rate) == null ? ResponseEntity.notFound().build() :
                ResponseEntity.ok().build();
    }

    @PutMapping("{movieId}/set-category/{categotyId}")
    public ResponseEntity<Movie> setCategory(@PathVariable long movieId,
                                             @PathVariable long categotyId) {
       try {
           movieService.addCategory(movieId, categotyId);
           return ResponseEntity.ok().build();
       } catch (RuntimeException exception) {
           return ResponseEntity.notFound().build();
       }
    }

    @GetMapping("/get-all-info/{id}")
    public ResponseEntity<MovieDto> getAllInfoById(@PathVariable long id) {
        MovieDto movieDto = movieService.returnMovieWithAllInfo(id);
        if (Objects.nonNull(movieDto)) {
            return ResponseEntity.ok(movieDto);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<MovieWithCutInfoDto> getAllWithCutInfo() {
        return movieService.getAllMoviesWithCutInfo().stream()
                .sorted(new MovieByIdComparator())
                .collect(Collectors.toList());
    }

    @GetMapping("/sorted")
    public List<MovieWithCutInfoDto> getSorted() {
        return movieService.getAllMoviesWithCutInfo().stream().sorted(new MovieComparator()).collect(Collectors.toList());
    }
}
