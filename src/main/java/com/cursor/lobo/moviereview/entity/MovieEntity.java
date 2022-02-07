package com.cursor.lobo.moviereview.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "movies")
public class MovieEntity extends BaseEntity {

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "movie_categories", joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<CategoryEntity> category;

    @Column(name = "director")
    private String director;

    @Column(name = "shortDescription")
    private String shortDescription;

    @Column(name = "rateValue")
    private int rateValue;

    @OneToOne(mappedBy = "movie")
    private RateEntity rate;

}
