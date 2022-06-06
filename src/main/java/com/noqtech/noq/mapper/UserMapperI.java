package com.noqtech.noq.mapper;

import com.noqtech.noq.dto.UserDto;
import com.noqtech.noq.entity.NoQUser;
import com.noqtech.noq.model.UserRequest;
import com.noqtech.noq.model.UserResponse;

public interface UserMapperI {
    public UserDto convertRequestToDto(UserRequest userRequest);

    public UserResponse convertDtoToResponse(UserDto userDto);

    public UserDto convertEntityToDto(NoQUser user);

    public NoQUser convertDtoToEntity(UserDto userDto);
}
