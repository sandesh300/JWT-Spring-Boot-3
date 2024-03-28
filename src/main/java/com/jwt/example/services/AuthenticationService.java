package com.jwt.example.services;

import com.jwt.example.dto.JwtAuthenticationResponse;
import com.jwt.example.dto.SignInRequest;
import com.jwt.example.dto.SignUpRequest;
import com.jwt.example.model.User;

public interface AuthenticationService {
    User signup(SignUpRequest signUpRequest);

    JwtAuthenticationResponse signin(SignInRequest signInRequest);
}
