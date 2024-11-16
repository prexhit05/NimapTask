package com.nimapInfotech.task.exception;

public class CatagoryNotFoundException extends RuntimeException{
    public CatagoryNotFoundException() {
        super("Category not found on the server");
    }

    public CatagoryNotFoundException(String message) {
        super(message);
    }
}
