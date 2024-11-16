package com.nimapInfotech.task.exception;

import com.nimapInfotech.task.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> resourseNotFoundExceptionHandler(ResourceNotFoundException ex){
        ApiResponse status = ApiResponse.builder().message(ex.getMessage()).success(true).status(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<>(status,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CatagoryNotFoundException.class)
    public ResponseEntity<ApiResponse> CatagoryNotFoundExceptionHandler(CatagoryNotFoundException ex){
        ApiResponse status = ApiResponse.builder().message(ex.getMessage()).success(true).status(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<>(status,HttpStatus.NOT_FOUND);
    }


}
