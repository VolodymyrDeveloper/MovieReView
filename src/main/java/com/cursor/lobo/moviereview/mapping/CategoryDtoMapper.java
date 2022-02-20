package com.cursor.lobo.moviereview.mapping;

import com.cursor.lobo.moviereview.entity.Category;
import com.cursor.lobo.moviereview.dto.CategoryDto;
import org.modelmapper.AbstractConverter;
import com.cursor.lobo.moviereview.enums.Genre;

public class CategoryDtoMapper extends AbstractConverter<Category, CategoryDto> {

    @Override
    protected CategoryDto convert(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .genre(Genre.valueOf(category.getGenre()).getGenre())
                .build();
    }
}
