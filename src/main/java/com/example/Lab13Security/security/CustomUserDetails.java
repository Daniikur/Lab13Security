package com.example.Lab13Security.security;

import com.example.Lab13Security.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails implements UserDetails {

    private final User user;

    // Constructor to initialize with the User object
    public CustomUserDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Assuming roles for the user, you can expand this part for more complex role systems.
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return user.getPassword();  // Return password from your User entity
    }

    @Override
    public String getUsername() {
        return user.getEmail();  // Return the email as the username
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;  // You can add expiration logic if needed
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;  // You can add locking logic if needed
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;  // You can add expiration logic for credentials if needed
    }

    @Override
    public boolean isEnabled() {
        return true;  // You can add logic to check if the user is enabled (e.g., if verified)
    }

    // Getter for the User entity
    public User getUser() {
        return user;
    }
}
