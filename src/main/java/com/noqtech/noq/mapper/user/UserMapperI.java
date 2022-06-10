package com.noqtech.noq.mapper.user;

import com.noqtech.noq.dto.UserDto;
import com.noqtech.noq.entity.User;
import com.noqtech.noq.model.user.UserRequest;
import com.noqtech.noq.model.user.UserResponse;

public interface UserMapperI {
    UserDto convertRequestToDto(UserRequest userRequest);

    UserResponse convertDtoToResponse(UserDto userDto);

    UserDto convertEntityToDto(User user);

    User convertDtoToEntity(UserDto userDto);
}
