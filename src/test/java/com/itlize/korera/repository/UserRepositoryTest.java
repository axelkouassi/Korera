package com.itlize.korera.repository;

import com.itlize.korera.model.Role;
import com.itlize.korera.model.User;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    //Create User
    @Test
    public void createUserTest(){
        User user = new User();
        user.setUsername("username1");
        user.setEmail("email1");
        user.setPassword("password1");
        user.setFirstName("firstName1");
        user.setLastName("lastName1");
        user.setPhone(123456789);
        user.setTimeCreated(LocalDateTime.now());
        user.setTimeUpdated(LocalDateTime.now());

        User userTest = userRepository.save(user);
        System.out.println(userTest);

        assertNotNull(userTest);
        assertEquals(user, userTest);
    }

    //Read User
    @Test
    public void readUserByIdTest(){
        Integer userId = 1;

        boolean doesUserExists = userRepository.existsById(userId);

        assertTrue(doesUserExists);
    }

    //Update User
    @Test
    public void updateUserByIdTest(){
        Integer userId= 1;
        User expected = userRepository.getById(userId);
        expected.setRole(Role.USER);
        expected.setTimeUpdated(LocalDateTime.now());

        User actual = userRepository.save(expected);

        assertEquals(Role.USER, actual.getRole());
    }

    //Delete User
    @Test
    public void deleteUserByIdTest(){
        Integer userId= 9;
        User expected = userRepository.getById(userId);

        userRepository.deleteById(userId);

        boolean actual = userRepository.existsById(userId);

        assertFalse(actual);
    }

    @Test
    void findByUsername() {
        String username = "username1";
        User user;
        user = new User();
        if(userRepository.findByUsername(username).isPresent()) {
            user = userRepository.findByUsername(username).get();
        }
        assertEquals(username,user.getUsername());
        boolean actual = userRepository.existsByUsername(username);
        assertTrue(actual);
    }

    @Test
    void deleteByUsername() {
        String username = "username1";
        User user = new User();
        if(userRepository.findByUsername(username).isPresent()) {
            userRepository.deleteByUsername(username);
            boolean actual = userRepository.existsByUsername(username);
            assertFalse(actual);
        }

    }
}