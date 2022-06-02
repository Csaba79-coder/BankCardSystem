package com.csaba79coder.bankcardsystem.config;

import com.csaba79coder.bankcardsystem.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity<ErrorResponse> handleIllegalArgument() {
        ErrorResponse errorResponse = new ErrorResponse("Please provide an input!");
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
