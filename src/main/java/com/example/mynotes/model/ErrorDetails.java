package com.example.mynotes.model;

public class ErrorDetails {
    private final String errorMessage;

    public ErrorDetails(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
