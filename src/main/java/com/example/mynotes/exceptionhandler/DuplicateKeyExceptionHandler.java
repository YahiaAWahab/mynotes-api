package com.example.mynotes.exceptionhandler;

import com.example.mynotes.model.ErrorDetails;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DuplicateKeyExceptionHandler {

    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseEntity<ErrorDetails> duplicateKeyExceptionHandler() {
        ErrorDetails errorDetails = new ErrorDetails("Username already exists.");

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorDetails);
    }
}
