package com.example.mynotes.exceptionhandler;

import com.example.mynotes.exception.UnauthorizedAccessException;
import com.example.mynotes.model.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UnauthorizedAccessExceptionHandler {

    @ExceptionHandler(UnauthorizedAccessException.class)
    public ResponseEntity<ErrorDetails> unauthorizedAccessExceptionHandler() {
        ErrorDetails errorDetails =  new ErrorDetails("Not authorized to access this resource.");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorDetails);
    }
}
