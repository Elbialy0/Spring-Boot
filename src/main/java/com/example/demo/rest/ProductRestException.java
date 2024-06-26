package com.example.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice

public class ProductRestException {
    @ExceptionHandler
    public ResponseEntity<ProductErrorResponse> handleProductNotFoundException(ProductNotFoundException exc){

        ProductErrorResponse error = new ProductErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTime();
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }



}
