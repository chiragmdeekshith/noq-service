package com.noqtech.noq.mapper.user;

import com.noqtech.noq.dto.UserDto;
import com.noqtech.noq.entity.User;
import com.noqtech.noq.model.user.UserRequest;
import com.noqtech.noq.model.user.UserResponse;

public interface UserMapperI {
    public UserDto convertRequestToDto(UserRequest userRequest);

    public UserResponse convertDtoToResponse(UserDto userDto);

    public UserDto convertEntityToDto(User user);

    public User convertDtoToEntity(UserDto userDto);
}
