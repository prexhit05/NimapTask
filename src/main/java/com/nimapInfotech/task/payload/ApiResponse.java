package com.nimapInfotech.task.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponse<T> {
    private String message;
    private HttpStatus status;
    private boolean success;
    private T data;

    public ApiResponse(String message, HttpStatus status, boolean success) {
        this.message = message;
        this.status = status;
        this.success = success;
    }

    public ApiResponse(String message, T data, boolean success, HttpStatus status) {
        this.message = message;
        this.data = data;
        this.success = success;
        this.status = status;
    }

    public ApiResponse(String message, boolean success, T data) {
        this.message = message;
        this.success = success;
        this.data = data;
    }

    public ApiResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
    }
}
