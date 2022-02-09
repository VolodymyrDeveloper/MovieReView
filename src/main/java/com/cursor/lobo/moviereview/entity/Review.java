package com.cursor.lobo.moviereview.entity;

import lombok.Setter;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.cursor.lobo.moviereview.enums.Rate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "review_id")
    int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    User user;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    Movie movie;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "review_message_id")
    ReviewMessage reviewMessage;

    @Enumerated(EnumType.STRING)
    @Column(name = "rate_value")
    Rate rate;

    @Column(name = "is_liked")
    boolean isLiked;
}