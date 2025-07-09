package com.itsprotsenko.ratingerbackend.service;

import com.itsprotsenko.ratingerbackend.exception.CategoryNotFoundException;
import com.itsprotsenko.ratingerbackend.model.Category;
import com.itsprotsenko.ratingerbackend.model.Item;
import com.itsprotsenko.ratingerbackend.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> responseCategories = categoryRepository.findAll();
        return new ResponseEntity<>(responseCategories, HttpStatus.OK);
    }

    public ResponseEntity<Category> getCategory(Long id) {
        Optional<Category> responseCategory = categoryRepository.findById(id);
        if(responseCategory.isPresent()) {
            return new ResponseEntity<>(responseCategory.get(), HttpStatus.OK);
        } else {
            throw new CategoryNotFoundException(id);
        }
    }

    public ResponseEntity<List<Item>> getItemsInCategory(Long id) {
        Optional<Category> responseCategory = categoryRepository.findById(id);
        if(responseCategory.isPresent()) {
            return new ResponseEntity<>(responseCategory.get().getItems(), HttpStatus.OK);
        } else {
            throw new CategoryNotFoundException(id);
        }
    }

    public ResponseEntity<Category> addCategory(Category category) {
        Category responseCategory = categoryRepository.save(category);
        return new ResponseEntity<>(responseCategory, HttpStatus.CREATED);
    }

    public ResponseEntity<Category> updateCategory(Category category) {
        if(categoryRepository.existsById(category.getId())) {
            Category responseCategory = categoryRepository.save(category);
            return new ResponseEntity<>(responseCategory, HttpStatus.OK);
        } else {
            throw new CategoryNotFoundException(category.getId());
        }
    }

    public ResponseEntity<String> deleteCategory(Long id) {
        if(categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
            return new ResponseEntity<>("Category deleted", HttpStatus.OK);
        } else {
            throw new CategoryNotFoundException(id);
        }
    }
}
