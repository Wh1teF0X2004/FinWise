package com.finance.FinWise.controller;

import com.finance.FinWise.model.User;
import com.finance.FinWise.security.JwtUtil;
import com.finance.FinWise.security.CustomUserDetailsService;
import com.finance.FinWise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody User user) throws Exception {
        // Authenticate the user
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUserEmail(), user.getUserPassword()));

        // Load user details using CustomUserDetailsService
        final UserDetails userDetails = customUserDetailsService.loadUserByUsername(user.getUserEmail());

        // Generate JWT token
        final String jwt = jwtUtil.generateToken(userDetails);

        // Return the token
        return ResponseEntity.ok(jwt);
    }
}