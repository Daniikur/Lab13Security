package com.example.Lab13Security.controller;

import com.example.Lab13Security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String email, @RequestParam String password) {
        userService.createUser(username, email, password);
        return "User registered successfully!";
    }

    @PostMapping("/authenticate")
    public String authenticateUser(@RequestParam String email, @RequestParam String password) {
        if (userService.authenticateUser(email, password)) {
            return "User authenticated successfully!";
        } else {
            return "Authentication failed!";
        }
    }
}
