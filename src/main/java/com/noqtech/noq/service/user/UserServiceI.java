package com.noqtech.noq.service.user;

import com.noqtech.noq.dto.UserDto;

public interface UserServiceI {
    public UserDto login(UserDto userDto);

    public UserDto register(UserDto userDto);

}
