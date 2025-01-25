package com.example.Lab13Security.service;

import com.example.Lab13Security.model.User;
import com.example.Lab13Security.repository.UserRepository;
import com.example.Lab13Security.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    // Implement the method to load user details by email
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Retrieve the user from the database by email
        User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
        
        // Return a CustomUserDetails object with the found user
        return new CustomUserDetails(user);
    }
}
