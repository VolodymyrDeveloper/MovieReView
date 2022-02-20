package com.cursor.lobo.moviereview.service;

import com.cursor.lobo.moviereview.dto.CategoryDto;
import com.cursor.lobo.moviereview.dto.CategoryWithMovieListDto;
import com.cursor.lobo.moviereview.enums.Genre;
import com.cursor.lobo.moviereview.entity.Category;
import com.cursor.lobo.moviereview.mapping.CategoryWithMovieListDtoMapper;
import com.cursor.lobo.moviereview.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    CategoryWithMovieListDtoMapper categoryWithMovieListDtoMapper;

    public void fillDBWithCategories() {
        Genre[] arrayOfGenres = Genre.values();
        for (Genre temp : arrayOfGenres) {
            Category category = new Category();
            category.setGenre(temp.name());
            categoryRepository.save(category);
        }
    }

    public CategoryDto findById(long id) {
        Optional<Category> returnCategory = categoryRepository.findById(id);
        if (returnCategory.isPresent()) {
            Category category = returnCategory.get();
            String genre = Genre.valueOf(category.getGenre()).getGenre();
            return CategoryDto.builder()
                    .id(category.getId())
                    .genre(genre)
                    .build();
        }
        return null;
    }

    public CategoryWithMovieListDto getMovieListByCategory(long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            return categoryWithMovieListDtoMapper.convert(category.get());
        }
        return null;
    }
}
