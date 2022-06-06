package com.noqtech.noq.controller;

import com.noqtech.noq.dto.UserDto;
import com.noqtech.noq.mapper.UserMapperI;
import com.noqtech.noq.model.UserRequest;
import com.noqtech.noq.model.UserResponse;
import com.noqtech.noq.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1/")
public class UserController {

    @Autowired
    private UserMapperI userMapper;

    @Autowired
    private UserServiceI userService;

    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@RequestBody UserRequest userRequest) {
        UserDto userDto = userMapper.convertRequestToDto(userRequest);
        userDto = userService.login(userDto);
        UserResponse userResponse = userMapper.convertDtoToResponse(userDto);
        return ResponseEntity.status(HttpStatus.OK).body(userResponse);
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody UserRequest userRequest) {
        UserDto userDto = userMapper.convertRequestToDto(userRequest);
        userDto = userService.register(userDto);
        UserResponse userResponse = userMapper.convertDtoToResponse(userDto);
        return ResponseEntity.status(HttpStatus.OK).body(userResponse);
    }
}