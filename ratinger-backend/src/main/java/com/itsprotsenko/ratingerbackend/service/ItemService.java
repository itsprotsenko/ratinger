package com.itsprotsenko.ratingerbackend.service;

import com.itsprotsenko.ratingerbackend.exception.CategoryNotFoundException;
import com.itsprotsenko.ratingerbackend.exception.ItemNotFoundException;
import com.itsprotsenko.ratingerbackend.model.Item;
import com.itsprotsenko.ratingerbackend.repository.CategoryRepository;
import com.itsprotsenko.ratingerbackend.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public ResponseEntity<Item> getItem(long id) {
        Optional<Item> responseItem = itemRepository.findById(id);
        if(responseItem.isPresent()) {
            return new ResponseEntity<>(responseItem.get(), HttpStatus.OK);
        } else {
            throw new ItemNotFoundException(id);
        }
    }

    public ResponseEntity<Item> addItem(Item item, Long categoryId) {
        if(categoryRepository.findById(categoryId).isPresent()) {
            item.setCategory(categoryRepository.findById(categoryId).get());
            Item responseItem = itemRepository.save(item);
            return new ResponseEntity<>(responseItem, HttpStatus.OK);
        } else {
            throw new CategoryNotFoundException(categoryId);
        }
    }

    public ResponseEntity<Item> updateItem(Item item) {
        if(itemRepository.existsById(item.getId())) {
            item.setCategory(itemRepository.findById(item.getId()).get().getCategory());
            Item responseItem = itemRepository.save(item);
            return new ResponseEntity<>(responseItem, HttpStatus.OK);
        } else {
            throw new ItemNotFoundException(item.getId());
        }

    }
    public ResponseEntity<String> deleteItem(long id) {
        if(itemRepository.existsById(id)) {
            itemRepository.deleteById(id);
            return new ResponseEntity<>("Item deleted", HttpStatus.OK);
        } else {
            throw new ItemNotFoundException(id);
        }
    }
}
