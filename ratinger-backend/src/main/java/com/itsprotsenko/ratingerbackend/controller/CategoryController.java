package com.itsprotsenko.ratingerbackend.controller;

import com.itsprotsenko.ratingerbackend.model.Category;
import com.itsprotsenko.ratingerbackend.model.Item;
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

    @GetMapping("/get/all")
    public ResponseEntity<List<Category>> getAllCategory() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable Long id) {
        return categoryService.getCategory(id);
    }

    @GetMapping("/get/items-in-category/{id}")
    public ResponseEntity<List<Item>> getItemsInCategory0(@PathVariable Long id) {
        return categoryService.getItemsInCategory(id);
    }

    @PostMapping("/add")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        return categoryService.addCategory(category);
    }

    @PutMapping("/edit")
    public ResponseEntity<Category> editCategory(@RequestBody Category category) {
        return categoryService.updateCategory(category);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
        return categoryService.deleteCategory(id);
    }
}
