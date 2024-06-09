package com.ra.validation_api.advice;

import com.ra.validation_api.model.dto.response.DataError;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class APIValidateAdvice {
    @ExceptionHandler(ConstraintViolationException.class)
    public DataError<Map<String, String>> handleConstraintViolationException(ConstraintViolationException e) {
        Map<String, String> errors = new HashMap<>();
        e.getConstraintViolations().forEach(constraintViolation -> {
            errors.put(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage());
        });
        return new DataError<>("message", errors, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public DataError<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach(error -> {
            errors.put(error.getDefaultMessage(), error.getDefaultMessage());
        });
        return new DataError<>("message", errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public DataError<String> handleNoSuchElementException(NoSuchElementException e) {
        return new DataError<>("message", e.getMessage(), HttpStatus.NOT_FOUND);
    }

//    @ExceptionHandler(ValidationException.class)
//    public DataError<String> handleValidationException(ValidationException e) {
//        return new DataError<>("message", e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//    }
}
