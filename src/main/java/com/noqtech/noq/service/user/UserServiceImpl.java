package com.noqtech.noq.service.user;

import com.google.common.hash.Hashing;
import com.noqtech.noq.constant.UserConstant;
import com.noqtech.noq.dto.UserDto;
import com.noqtech.noq.entity.User;
import com.noqtech.noq.mapper.user.UserMapperI;
import com.noqtech.noq.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserServiceI {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapperI userMapper;

    @Override
    public UserDto login(UserDto userDto) {
        User user = userRepository.findByEmailId(userDto.getEmailId());
        String password = userDto.getPassword();
        userDto.setPassword("");
        if (Objects.isNull(user)) {
            userDto.setMessage(UserConstant.USER_NOT_FOUND);
            return userDto;
        }
        UserDto userDtoFromDb = userMapper.convertEntityToDto(user);
        String hashedPassword = Hashing
                .sha256()
                .hashString(password, StandardCharsets.UTF_8)
                .toString();
        if (!userDtoFromDb.getPassword().equals(hashedPassword)) {
            userDto.setMessage(UserConstant.LOGIN_FAILED);
            return userDto;
        }
        userDtoFromDb.setMessage(UserConstant.LOGIN_SUCCESSFUL);
        return userDtoFromDb;
    }

    @Override
    public UserDto register(UserDto userDto) {

        User user = userRepository.findByEmailId(userDto.getEmailId());
        if (!Objects.isNull(user)) {
            userDto.setMessage(UserConstant.EMAIL_ID_ALREADY_EXISTS);
            return userDto;
        }
        String password = userDto.getPassword();
        String hashedPassword = Hashing
                .sha256()
                .hashString(password, StandardCharsets.UTF_8)
                .toString();
        userDto.setPassword(hashedPassword);
        user = new User(userDto);
        user = userRepository.saveAndFlush(user);
        userDto = userMapper.convertEntityToDto(user);
        if (!Objects.isNull(user.getUserId())) {
            userDto.setMessage(UserConstant.REGISTRATION_SUCCESSFUL);
        } else {
            userDto.setMessage(UserConstant.REGISTRATION_FAILED);
        }
        return userDto;
    }
}