package com.itsprotsenko.ratingerbackend.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler({CategoryNotFoundException.class, ItemNotFoundException.class, BaseException.class})
    public ResponseEntity<Object> handleException(BaseException exception, WebRequest request) {
        return new ResponseEntity<>(exception, exception.getStatus());
    }
}
