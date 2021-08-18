package com.itlize.korera.service.serviceimpl;

import com.itlize.korera.model.Role;
import com.itlize.korera.model.User;
import com.itlize.korera.repository.UserRepository;
import com.itlize.korera.service.UserService;
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
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    //Check if username exists
    @Override
    public boolean usernameExists(String username){
        return userRepository.findByUsername(username).isPresent();
    }

    //Checking if user exists by Id
    @Override
    public boolean userIdExists(Integer userId){
        return userRepository.existsById(userId);
    }

    //Saving user information
    @Override
    public User saveUser(User user) {
        log.info("Encrypting password.");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setTimeCreated(LocalDateTime.now());
        user.setTimeUpdated(LocalDateTime.now());
        log.info("Saving new user to the database.");
        return userRepository.save(user);
    }

    //Find user by username
    @Override
    public User findByUsername(String username) {
        log.info("Fetching user with username: " + username + "...");
        User user =  userRepository.findByUsername(username).orElse(null);
        if(user == null){
            throw new UsernameNotFoundException("Username: " + username + " was not found in the database.");
        }

        return user;
    }

    //Find user by user id
    @Override
    public User findByUserId(Integer userId) {
        log.info("Fetching user with id: " + userId + "...");
        User user =  userRepository.findById(userId).orElse(null);
        if(user == null){
            throw new UsernameNotFoundException("User id: " + userId + " was not found in the database.");
        }

        return user;
    }

    //Find all users
    @Override
    public List<User> getUsers() {
        log.info("Fetching all users.");
        return userRepository.findAll();
    }

    //Update username
    @Override
    public User updateUsername(User user, String username) {
        String original = user.getUsername();
        log.info("Updating username " + original + " to " + username + "...");
        user.setUsername(username);
        user.setTimeUpdated(LocalDateTime.now());
        log.info("Username " + original + " has been updated to " + username + ".");
        return userRepository.save(user);
    }

    //Update password
    @Override
    public User updatePassword(User user, String password) {
        String original = passwordEncoder.encode(user.getPassword());
        log.info("Updating password " + original + " to " + password + "...");
        log.info("Encoding new password " + password +"...");
        password = passwordEncoder.encode(password);
        user.setPassword(password);
        user.setTimeUpdated(LocalDateTime.now());
        log.info("Password " + original + " has been updated to " + password + ".");
        return userRepository.save(user);
    }

    //Update email
    @Override
    public User updateEmail(User user, String email) {
        String original = user.getEmail();
        log.info("Updating email " + original + " to " + email + "...");
        user.setEmail(email);
        user.setTimeUpdated(LocalDateTime.now());
        log.info("Email " + original + " has been updated to " + email + ".");
        return userRepository.save(user);
    }

    //Update first name
    @Override
    public User updateFirstName(User user, String firstName) {
        String original = user.getFirstName();
        log.info("Updating first name " + original + " to " + firstName + "...");
        user.setFirstName(firstName);
        user.setTimeUpdated(LocalDateTime.now());
        log.info("First name " + original + " has been updated to " + firstName + ".");
        return userRepository.save(user);
    }

    //Update last name
    @Override
    public User updateLastName(User user, String lastName) {
        String original = user.getLastName();
        log.info("Updating last name " + original + " to " + lastName + "...");
        user.setLastName(lastName);
        user.setTimeUpdated(LocalDateTime.now());
        log.info("Last name " + original + " has been updated to " + lastName + ".");
        return userRepository.save(user);
    }

    //Update phone
    @Override
    public User updatePhone(User user, Integer phone) {
        Integer original = user.getPhone();
        log.info("Updating phone " + original + " to " + phone + "...");
        user.setPhone(phone);
        user.setTimeUpdated(LocalDateTime.now());
        log.info("Phone " + original + " has been updated to " + phone + ".");
        return userRepository.save(user);
    }

    //Update phone
    @Override
    public User updateRole(User user, Role role) {
        log.info("Updating first name.");
        user.setRole(role);
        user.setTimeUpdated(LocalDateTime.now());
        log.info("Saving new updated role information to the database.");
        return userRepository.save(user);
    }

    //Delete user by username
    @Override
    public void deleteByUsername(String username) {
        log.info("Deleting user with username: " + username);
        userRepository.deleteByUsername(username);
    }

    //Delete user by user id
    @Override
    public void deleteByUserId(Integer userId) {
        log.info("Deleting user with username: " + userId);
        userRepository.deleteById(userId);
    }

    //Delete all users
    @Override
    public void deleteUsers() {
        log.info("Deleting all users.");
        userRepository.deleteAll();
    }
}
