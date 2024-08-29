package com.workintech.s18d1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<BurgerErrorResponse> exceptionHandler(BurgerException exception) {
        BurgerErrorResponse burgerErrorResponse = new BurgerErrorResponse(exception.getLocalizedMessage());
        return new ResponseEntity<>(burgerErrorResponse, exception.getHttpStatus());
    }

    @ExceptionHandler
    public ResponseEntity<BurgerErrorResponse> exceptionHandler(Exception exception) {
        BurgerErrorResponse burgerErrorResponse = new BurgerErrorResponse(exception.getLocalizedMessage());
        return new ResponseEntity<>(burgerErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
