package com.itsprotsenko.ratingerbackend.repository;

import com.itsprotsenko.ratingerbackend.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
    List<Category> findAll();
}