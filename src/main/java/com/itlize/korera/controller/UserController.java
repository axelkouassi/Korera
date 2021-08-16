package com.itlize.korera.controller;

import com.itlize.korera.model.User;
import com.itlize.korera.service.UserService;
import com.itlize.korera.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserService service;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtTokenUtil;
    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/register")
    public ResponseEntity<User> createUser(@RequestBody User user){
        URI uri = URI.create(ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/korera/user/register")
                .toUriString());
        return ResponseEntity.created(uri).body(service.saveUser(user));
    }

    //sign in
    @GetMapping( "/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody User user )  throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
            );
        }
        catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());

        User response = service.findByUsername(user.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);
        //jwt gives token in postman switch with user to get user details
        return  new ResponseEntity<>(jwt, HttpStatus.OK);
    }


    @GetMapping("/username")
    public ResponseEntity<User> getUser(@RequestBody String username){
        return ResponseEntity.ok().body(service.findByUsername(username));
    }

    @GetMapping("/getusers")
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok().body(service.getUsers());
    }


}
