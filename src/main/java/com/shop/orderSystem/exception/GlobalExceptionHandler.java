package com.shop.orderSystem.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;
 @RestControllerAdvice//this tell handle all error in global for all controls
public class GlobalExceptionHandler {
    
 @ExceptionHandler(MethodArgumentNotValidException.class)
public Map<String, String> handleValidationErrors(MethodArgumentNotValidException ex) {

    Map<String, String> errors = new HashMap<>();

    ex.getBindingResult().getFieldErrors().forEach(error -> {
        errors.put(error.getField(), error.getDefaultMessage());
    });

    return errors;
}
  
}
