package com.itlize.korera.service;

import com.itlize.korera.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser(User user);
    User findByUsername(String username);
    User findByUserId(Integer userId);
    List<User> getUsers();
    void deleteByUsername(String username);
    void deleteUsers();

}
