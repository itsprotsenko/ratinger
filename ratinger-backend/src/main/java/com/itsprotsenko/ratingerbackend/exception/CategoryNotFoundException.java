package com.itsprotsenko.ratingerbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class CategoryNotFoundException extends BaseException {
    public CategoryNotFoundException() {
        super(HttpStatus.NOT_FOUND, "Category not found");
    }

    public CategoryNotFoundException(Long id) {
        super(HttpStatus.NOT_FOUND, "Category with ID " + id + " not found");
    }
}
