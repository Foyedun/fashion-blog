package com.example.week8.controller;

import com.example.week8.dto.LogInDto;
import com.example.week8.dto.UserDto;
import com.example.week8.projo.ApiResponse;
import com.example.week8.serviceimplementation.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


    @RestController
    @RequestMapping("/user")
    @AllArgsConstructor
    public class UserController {
        private final UserServiceImpl userService;

        @PostMapping("/signup")
        public ApiResponse<ApiResponse> userSignup(@RequestBody UserDto userDto) {return userService.signUp(userDto);}

        @PostMapping ("/signin")
        public ApiResponse<ApiResponse> userSignIn(@RequestBody LogInDto logInDto){return userService.logIn(logInDto);}



}
