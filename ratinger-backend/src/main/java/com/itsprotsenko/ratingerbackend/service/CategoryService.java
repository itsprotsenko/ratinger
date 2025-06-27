package com.itsprotsenko.ratingerbackend.service;

import com.itsprotsenko.ratingerbackend.model.Category;
import com.itsprotsenko.ratingerbackend.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    public ResponseEntity<Category> addCategory(Category category) {
        Category responseCategory = categoryRepository.save(category);
        return new ResponseEntity<>(responseCategory, HttpStatus.CREATED);
    }
}
