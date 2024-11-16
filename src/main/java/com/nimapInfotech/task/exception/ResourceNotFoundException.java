package com.nimapInfotech.task.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException() {
        super("Resource Not Found on the server");
    }
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
