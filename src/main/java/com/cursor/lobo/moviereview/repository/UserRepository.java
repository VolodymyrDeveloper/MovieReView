package com.cursor.lobo.moviereview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cursor.lobo.moviereview.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
