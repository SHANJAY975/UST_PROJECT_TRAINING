package com.ust.springboot.todos.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(Exception.class)
    public  ResponseEntity<ExceptionResponses> handleException(Exception exc){
        return buildResponseEntity(exc, HttpStatus.BAD_REQUEST);
    }


    private ResponseEntity<ExceptionResponses> buildResponseEntity(Exception exc, HttpStatus status){
        ExceptionResponses error = new ExceptionResponses();
        error.setStatus(status.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, status);
    }
}
