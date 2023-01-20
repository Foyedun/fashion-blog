package com.example.week8.serviceimplementation;

import com.example.week8.dto.LogInDto;

import com.example.week8.dto.UserDto;
import com.example.week8.entities.UserEntity;
import com.example.week8.exception.ErrorMessages;
import com.example.week8.exception.UserServiceException;
import com.example.week8.projo.ApiResponse;
import com.example.week8.projo.ResponseManager;
import com.example.week8.projo.UserResponse;
import com.example.week8.repository.UserRepository;
import com.example.week8.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ResponseManager responseManager;


    @Override
    public ApiResponse signUp(UserDto userDto) {
        UserResponse userResponse = new UserResponse();
        UserEntity userEntity = userRepository.findByUserEmail(userDto.getEmail());
        if(userEntity != null){
            throw new UserServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessages());
        }
        UserEntity userEntityToSave = new UserEntity();
        BeanUtils.copyProperties(userDto, userEntityToSave);
        UserEntity userEntityCreated = userRepository.save(userEntityToSave);
        BeanUtils.copyProperties(userEntityCreated, userResponse);
        return responseManager.success(HttpStatus.CREATED, userResponse);


    }

    @Override
    public ApiResponse logIn(LogInDto logInDto) {
        UserResponse userResponse = new UserResponse();
        UserEntity userEntity = userRepository.findByUserEmail(logInDto.getEmail());
        if (userEntity == null) {
            throw new UserServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessages());
        }
        if (!userEntity.getPassword().equals(logInDto.getPassword()))
            throw new UserServiceException(ErrorMessages.INCORRECT_LOGIN_DETAILS.getErrorMessages());
        BeanUtils.copyProperties(userEntity, userResponse);
        return responseManager.success(HttpStatus.OK, userResponse);
    }
}
