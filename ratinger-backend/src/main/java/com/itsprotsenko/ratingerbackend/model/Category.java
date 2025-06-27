package com.itsprotsenko.ratingerbackend.model;

import com.itsprotsenko.ratingerbackend.enums.Color;
import jakarta.persistence.*;
import lombok.Data;

import static com.itsprotsenko.ratingerbackend.enums.Color.GREY;

@Entity
@Table(name="category")
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String name;

    @Column(length = 511)
    String description;

    @Column(columnDefinition = "varchar(255) default 'GREY'", nullable = false)
    @Enumerated(EnumType.STRING)
    Color color = GREY;
}
