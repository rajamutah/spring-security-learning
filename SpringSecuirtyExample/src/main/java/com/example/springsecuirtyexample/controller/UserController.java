package com.example.springsecuirtyexample.controller;

import com.example.springsecuirtyexample.model.Users;
import com.example.springsecuirtyexample.service.UserService;
import com.example.springsecuirtyexample.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping("/register")
    public Users register(@RequestBody Users user) {
        return userServiceImpl.register(user);
    }
}
