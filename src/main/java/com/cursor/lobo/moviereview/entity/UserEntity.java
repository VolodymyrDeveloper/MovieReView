package com.cursor.lobo.moviereview.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

    @Column(name = "login", unique = true, nullable = false)
    private String login;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "username")
    private String username;

}
