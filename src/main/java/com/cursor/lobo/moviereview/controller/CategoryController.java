package com.cursor.lobo.moviereview.controller;

import com.cursor.lobo.moviereview.dto.CategoryDto;
import com.cursor.lobo.moviereview.dto.CategoryWithMovieListDto;
import com.cursor.lobo.moviereview.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getById(@PathVariable long id) {
        System.out.println(categoryService.findById(id));
        return ResponseEntity.ok(categoryService.findById(id));
    }

    @GetMapping("/{id}/movie-list")
    public ResponseEntity<CategoryWithMovieListDto> getCategoryWithMovieList(@PathVariable long id) {
        CategoryWithMovieListDto returnValue = categoryService.getMovieListByCategory(id);
        if (Objects.nonNull(returnValue)) {
            return ResponseEntity.ok(returnValue);
        }
        return ResponseEntity.notFound().build();
    }

}
