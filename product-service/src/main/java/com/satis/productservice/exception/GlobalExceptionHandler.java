package com.satis.productservice.exception;

import com.satis.productservice.Response.MessageResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<MessageResponse> handleProductNotFoundException(ProductNotFoundException exception) {
        MessageResponse response = new MessageResponse(exception.getMessage());
        System.out.println("Hello");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

}
