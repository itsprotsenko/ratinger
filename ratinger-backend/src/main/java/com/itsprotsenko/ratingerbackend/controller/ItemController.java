package com.itsprotsenko.ratingerbackend.controller;

import com.itsprotsenko.ratingerbackend.model.Item;
import com.itsprotsenko.ratingerbackend.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping("/get/{id}")
    public ResponseEntity<Item> getItem(@PathVariable long id) {
        return itemService.getItem(id);
    }

    @PostMapping("/add/{categoryId}")
    public ResponseEntity<Item> addItem(@PathVariable Long categoryId, @RequestBody Item item) {
        return itemService.addItem(item, categoryId);
    }

    @PutMapping("/edit")
    public ResponseEntity<Item> editItem(@RequestBody Item item) {
        return itemService.updateItem(item);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable long id) {
        return itemService.deleteItem(id);
    }
}
