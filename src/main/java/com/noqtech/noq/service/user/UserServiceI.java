package com.noqtech.noq.service.user;

import com.noqtech.noq.dto.UserDto;

public interface UserServiceI {
    UserDto login(UserDto userDto);

    UserDto register(UserDto userDto);

}
