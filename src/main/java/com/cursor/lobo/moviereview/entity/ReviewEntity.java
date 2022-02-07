package com.cursor.lobo.moviereview.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "reviews")
public class ReviewEntity extends BaseEntity {

    @Column(name = "rateValue")
    private String reviewMessage;

    @Column(name = "liked")
    private boolean liked;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private MovieEntity movie;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
