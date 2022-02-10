package com.cursor.lobo.moviereview.repository;

import com.cursor.lobo.moviereview.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.cursor.lobo.moviereview.entity.Category;

import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Override
    <S extends Movie> S save(S entity);

    @Override
    Optional<Movie> findById(Long Long);

    @Query("select m from Movie m where m.category = :categoryList")
    List<Movie> findAllByCategory(List<Category> categoryList);


}
