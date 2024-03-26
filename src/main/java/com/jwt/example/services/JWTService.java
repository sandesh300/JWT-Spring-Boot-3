package com.jwt.example.services;

import org.springframework.security.core.userdetails.UserDetails;

public interface JWTService {

    String extractUserName(String jwt);

    String generateToken(UserDetails userDetails);

    boolean isTokenValid(String token, UserDetails userDetails);
}
