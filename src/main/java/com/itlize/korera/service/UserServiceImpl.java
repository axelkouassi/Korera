package com.itlize.korera.service;

import com.itlize.korera.model.User;
import com.itlize.korera.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j // logs
public class UserServiceImpl implements UserService{

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user) {
        log.info("Encrypting password.");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setTimeCreated(LocalDateTime.now());
        user.setTimeUpdated(LocalDateTime.now());
        log.info("Saving new user to the database.");
        return userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        log.info("Fetching user with username: " + username);
        User user =  userRepository.findByUsername(username).orElse(null);
        if(user == null){
            throw new UsernameNotFoundException("Username: " + username + " was not found in the database.");
        }

        return user;
    }

    @Override
    public User findByUserId(Integer userId) {
        log.info("Fetching user with id: " + userId);
        User user =  userRepository.findById(userId).orElse(null);
        if(user == null){
            throw new UsernameNotFoundException("User id: " + userId + " was not found in the database.");
        }

        return user;
    }

    @Override
    public List<User> getUsers() {
        log.info("Fetching all users.");
        return userRepository.findAll();
    }

    @Override
    public void deleteByUsername(String username) {
        log.info("Deleting user with username: " + username);
        userRepository.deleteByUsername(username);
    }

    @Override
    public void deleteUsers() {
        log.info("Deleting all users.");
        userRepository.deleteAll();
    }
}
