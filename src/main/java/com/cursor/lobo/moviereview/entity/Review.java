package com.cursor.lobo.moviereview.entity;

import lombok.Setter;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "review_message")
    private String reviewMessage;

    @Column(name = "is_liked")
    private boolean isLiked;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    Movie movie;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    User user;

    public boolean getIsLiked() {
        return this.isLiked;
    }
}
