package com.example.Lab13Security.service;

import com.example.Lab13Security.model.User;
import com.example.Lab13Security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // Create a new user
    public User createUser(String username, String email, String password) {
        String encodedPassword = passwordEncoder.encode(password);
        User user = new User(username, email, encodedPassword);
        return userRepository.save(user);
    }

    // Authenticate a user by email and password
    public boolean authenticateUser(String email, String password) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            return passwordEncoder.matches(password, user.get().getPassword());
        }
        return false;
    }
}
