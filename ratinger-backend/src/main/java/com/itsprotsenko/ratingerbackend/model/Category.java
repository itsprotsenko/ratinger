package com.itsprotsenko.ratingerbackend.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.itsprotsenko.ratingerbackend.enums.Color;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

import static com.itsprotsenko.ratingerbackend.enums.Color.GREY;

@Entity
@Table(name="category")
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(length = 511)
    private String description;

    @Column(columnDefinition = "varchar(255) default 'GREY'", nullable = false)
    @Enumerated(EnumType.STRING)
    private Color color = GREY;

    @JsonManagedReference
    @OneToMany(mappedBy = "category", cascade=CascadeType.ALL)
    private List<Item> items;
}
