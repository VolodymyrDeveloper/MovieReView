package com.cursor.lobo.moviereview;

import com.cursor.lobo.moviereview.entity.Category;
import com.cursor.lobo.moviereview.service.CategoryService;
import com.cursor.lobo.moviereview.enums.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MovieReViewApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(MovieReViewApplication.class, args);
//        Category category = new Category();
//        category.setGenre(Genre.ACT);
        CategoryService categoryService = applicationContext.getBean(CategoryService.class);
//        categoryService.save(category);
        System.out.println(categoryService.findById(1));
    }

}
