package com.cursor.lobo.moviereview.entity;

import lombok.Setter;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rates")
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rate_value")
    private Double rateValue;

    @Column(name = "count_of_votes")
    private int countOfVotes;

    @OneToOne(mappedBy = "rateValue")
    private Movie movie;

    public int compareTo(Rate rateValue) {
        return this.rateValue.compareTo(rateValue.getRateValue());
    }
}
