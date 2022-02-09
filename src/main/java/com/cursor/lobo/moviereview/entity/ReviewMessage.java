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
public class ReviewMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "review_message_id")
    int id;

    @Column(name = "review_message")
    String message;

    @OneToOne(mappedBy = "reviewMessage")
    Review review;
}