package com.noqtech.noq.mapper;

import com.noqtech.noq.dto.UserDto;
import com.noqtech.noq.entity.NoQUser;
import com.noqtech.noq.model.UserRequest;
import com.noqtech.noq.model.UserResponse;
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

    public UserDto convertEntityToDto(NoQUser user) {
        return modelMapper.map(user, UserDto.class);
    }

    public NoQUser convertDtoToEntity(UserDto userDto) {
        return modelMapper.map(userDto, NoQUser.class);
    }
}
