package com.cursor.lobo.moviereview;

import com.cursor.lobo.moviereview.service.CategoryService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MovieReViewApplication {

    public static void main(String[] args) {
//        ApplicationContext applicationContext =
        SpringApplication.run(MovieReViewApplication.class, args);
//        CategoryService categoryService = applicationContext.getBean(CategoryService.class);
//        categoryService.fillDBWithCategories();
    }

}
