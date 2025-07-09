package com.itsprotsenko.ratingerbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ItemNotFoundException extends BaseException {
    public ItemNotFoundException() {
        super("Item not found", HttpStatus.NOT_FOUND);
    }
    public ItemNotFoundException(Long id) {
        super("Item with ID " + id + " not found", HttpStatus.NOT_FOUND);
    }
}
