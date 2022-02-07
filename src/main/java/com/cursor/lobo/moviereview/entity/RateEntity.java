package com.cursor.lobo.moviereview.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "rates")
public class RateEntity extends BaseEntity {

    @Column(name = "rateValue")
    private int rateValue;

    @Column(name = "countOfVotes")
    private int countOfVotes;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_id", referencedColumnName = "id")
    private MovieEntity movie;

}
