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

import com.cursor.lobo.moviereview.enums.Genre;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "genre")
    private Genre genre;

    @Override
    public String toString() {
        return "Category(id=" + id
                + ", genre" + this.genre.getGenre() + ")";
    }

}
