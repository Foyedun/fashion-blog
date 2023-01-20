package com.example.week8.service;

import com.example.week8.dto.LogInDto;
import com.example.week8.dto.UserDto;
import com.example.week8.projo.ApiResponse;
import com.example.week8.projo.UserResponse;

public interface UserService {
    ApiResponse signUp(UserDto userDto);

    ApiResponse logIn(LogInDto logInDto);
}
