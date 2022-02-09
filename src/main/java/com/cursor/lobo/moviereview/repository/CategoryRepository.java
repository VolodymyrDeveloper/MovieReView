package com.cursor.lobo.moviereview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cursor.lobo.moviereview.entity.Category;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Category findById(int id);
}
