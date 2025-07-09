package com.itsprotsenko.ratingerbackend.repository;

import com.itsprotsenko.ratingerbackend.model.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item, Long> {
    List<Item> findAll();
}
