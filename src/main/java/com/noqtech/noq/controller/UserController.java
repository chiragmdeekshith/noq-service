package com.noqtech.noq.controller;

import com.noqtech.noq.dto.UserDto;
import com.noqtech.noq.mapper.user.UserMapperI;
import com.noqtech.noq.model.user.UserRequest;
import com.noqtech.noq.model.user.UserResponse;
import com.noqtech.noq.service.user.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(name = "/")
public class UserController {
    @Autowired
    private UserMapperI userMapper;
    @Autowired
    private UserServiceI userService;

    @PostMapping("/v1/user/login")
    public ResponseEntity<UserResponse> login(@RequestBody UserRequest userRequest) {
        UserDto userDto = userMapper.convertRequestToDto(userRequest);
        userDto = userService.login(userDto);
        UserResponse userResponse = userMapper.convertDtoToResponse(userDto);
        return ResponseEntity.status(HttpStatus.OK).body(userResponse);
    }

    @PostMapping("/v1/user/register")
    public ResponseEntity<UserResponse> register(@RequestBody UserRequest userRequest) {
        UserDto userDto = userMapper.convertRequestToDto(userRequest);
        userDto = userService.register(userDto);
        UserResponse userResponse = userMapper.convertDtoToResponse(userDto);
        return ResponseEntity.status(HttpStatus.OK).body(userResponse);
    }
}