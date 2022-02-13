package com.cursor.lobo.moviereview.controller;

import com.cursor.lobo.moviereview.dto.MovieDto;
import com.cursor.lobo.moviereview.dto.MovieDtoWithCutInfo;
import com.cursor.lobo.moviereview.entity.Movie;
import com.cursor.lobo.moviereview.entity.Rate;
import com.cursor.lobo.moviereview.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    /*HttpMessageNotReadableException: JSON parse error: Cannot deserialize value of type
    nested exception is MismatchedInputException: Cannot deserialize value of type*/
    @PostMapping
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        Movie returnValue = movieService.addMovie(movie);
        return ResponseEntity.ok(returnValue);
    }

    /* ok
    200, 200 for non-existent value, 400-for str
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Movie> deleteById(@PathVariable("id") Long id) {
        Movie returnValue = movieService.deleteById(id);
        return ResponseEntity.ok(returnValue);
    }

    /*400
    HttpMessageNotReadableException: JSON parse error: Cannot deserialize value of type...
    nested exception is MismatchedInputException: Cannot deserialize value of type...*/
    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovieById(@PathVariable("id") Long id, @RequestBody Movie movie) {
        Movie returnValue = movieService.updateMovieById(id, movie);
        return ResponseEntity.ok(returnValue);
    }

    /* ok
    200, 200 for non-existent value, 400-for str
     */
    @GetMapping("/list/all-info/{id}")
    public ResponseEntity<MovieDto> getMovieWithAllInfoById(@PathVariable("id") Long id) {
        MovieDto returnValue = movieService.getMovieWithAllInfoById(id);
        return ResponseEntity.ok(returnValue);
    }

    /*400
    В оцінках фільм, а в фільмі оцінка, не можу підібрати запит
    HttpMessageNotReadableException: JSON parse error: Cannot deserialize value of type ... entity.Rate
    nested exception is MismatchedInputException: Cannot deserialize value of type ... entity.Rate
     */
    @PutMapping("/rate/{id}")
    public ResponseEntity<Movie> updateRate(@PathVariable("id") Long id, @RequestBody Rate rate) {
        Movie returnValue = movieService.updateRate(id, rate);
        return ResponseEntity.ok(returnValue);
    }

    /*200
    робить сортування від меньшого до більшого, але
    у Movie посилання на Rate, а в Rate посилання на Movie
     */

    @GetMapping("/list/cut-info")
    public List<MovieDtoWithCutInfo> returnListOfMovieWithCutInfo() {
        List<MovieDtoWithCutInfo> returnValue = movieService.returnListOfMovieWithCutInfo();
        return returnValue;
    }

    /*200
    працює з помилкою
     */
    @GetMapping("/list/sorted-by-rate")
    public List<Movie> returnMoviesSortedByRateValue() {
        List<Movie> returnValue = movieService.returnMoviesSortedByRateValue();
        return returnValue;
    }
}
