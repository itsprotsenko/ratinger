package com.itsprotsenko.ratingerbackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="item")
@Data
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    Long id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="category_id", nullable=false)
    Category category;

    @Column(nullable = false)
    String name;

    @Column(columnDefinition = "integer default 0 check(RATING between 0 and 10)")
    Integer rating = 0;

    @Column(length = 511)
    String description;
}
