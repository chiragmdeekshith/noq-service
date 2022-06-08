package com.noqtech.noq.mapper.user;

import com.noqtech.noq.dto.UserDto;
import com.noqtech.noq.entity.User;
import com.noqtech.noq.model.user.UserRequest;
import com.noqtech.noq.model.user.UserResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapperI {
    @Autowired
    private ModelMapper modelMapper;

    public UserDto convertRequestToDto(UserRequest userRequest) {
        return modelMapper.map(userRequest, UserDto.class);
    }

    public UserResponse convertDtoToResponse(UserDto userDto) {
        return modelMapper.map(userDto, UserResponse.class);
    }

    public UserDto convertEntityToDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }

    public User convertDtoToEntity(UserDto userDto) {
        return modelMapper.map(userDto, User.class);
    }
}
