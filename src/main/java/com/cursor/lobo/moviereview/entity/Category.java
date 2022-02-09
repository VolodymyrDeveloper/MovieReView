package com.cursor.lobo.moviereview.entity;

import lombok.Setter;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.cursor.lobo.moviereview.enums.Genre;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "category_id")
    int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "genre")
    Genre genre;

    @Override
    public String toString() {
        return "Category(id=" + this.id +
                ", genre=" + this.genre.getGenre() + ")";
    }
}
