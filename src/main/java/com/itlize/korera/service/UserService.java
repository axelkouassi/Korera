package com.itlize.korera.service;

import com.itlize.korera.model.Role;
import com.itlize.korera.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    boolean usernameExists(String username);
    boolean userIdExists(Integer userId);
    User saveUser(User user);
    User findByUsername(String username);
    User findByUserId(Integer userId);
    List<User> getUsers();
    User updateUsername(User user, String username);
    User updatePassword(User user, String password);
    User updateEmail(User user, String email);
    User updateFirstName(User user, String firstName);
    User updateLastName(User user, String lastName);
    User updatePhone(User user, Integer phone);
    User updateRole(User user, Role role);
    void deleteByUsername(String username);
    void deleteByUserId(Integer userId);
    void deleteUsers();

}
