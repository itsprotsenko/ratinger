package com.itsprotsenko.ratingerbackend.controller;

import com.itsprotsenko.ratingerbackend.model.Category;
import com.itsprotsenko.ratingerbackend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Category>> getAllCategory() {
        return categoryService.getAllCategories();
    }

    @PostMapping("/add")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        return categoryService.addCategory(category);
    }
}
