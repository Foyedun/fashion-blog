package com.example.week8.projo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ApiResponse<T> extends UserResponse{
    private int httpStatusCode;
    private HttpStatus status;
    private String message;
    private boolean success;
    private T data;


}
