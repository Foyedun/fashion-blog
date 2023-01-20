package com.example.week8.exception;

public class UserServiceException extends RuntimeException{
    public UserServiceException(String message){
        super(message);
    }
}
