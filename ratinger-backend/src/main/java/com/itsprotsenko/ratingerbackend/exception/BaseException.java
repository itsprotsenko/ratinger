package com.itsprotsenko.ratingerbackend.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class BaseException extends RuntimeException {
    private final HttpStatus status;

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }

    public BaseException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }
}
