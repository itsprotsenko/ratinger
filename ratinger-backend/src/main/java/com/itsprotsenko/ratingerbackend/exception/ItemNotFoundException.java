package com.itsprotsenko.ratingerbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ItemNotFoundException extends BaseException {
    public ItemNotFoundException() {
        super(HttpStatus.NOT_FOUND, "Item not found");
    }
    public ItemNotFoundException(Long id) {
        super(HttpStatus.NOT_FOUND, "Item with ID " + id + " not found");
    }
}
