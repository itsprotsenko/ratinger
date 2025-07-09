package com.itsprotsenko.ratingerbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class CategoryNotFoundException extends BaseException {
    public CategoryNotFoundException() {
        super("Category not found", HttpStatus.NOT_FOUND);
    }

    public CategoryNotFoundException(Long id) {
        super("Category with ID " + id + " not found", HttpStatus.NOT_FOUND);
    }
}
