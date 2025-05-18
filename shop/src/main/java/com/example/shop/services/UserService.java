package com.example.shop.services;

import com.example.shop.dto.UserDto;
import com.example.shop.entity.User;
import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}

