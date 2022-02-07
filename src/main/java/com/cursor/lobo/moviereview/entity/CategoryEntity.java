package com.cursor.lobo.moviereview.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "categories")
public class CategoryEntity extends BaseEntity {

    @Column(name = "code")
    private String code;

    @Column(name = "readableName")
    private String readableName;

}
