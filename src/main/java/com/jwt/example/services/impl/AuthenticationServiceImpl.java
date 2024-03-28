package com.jwt.example.services.impl;

import com.jwt.example.dto.JwtAuthenticationResponse;
import com.jwt.example.dto.RefreshTokenRequest;
import com.jwt.example.dto.SignInRequest;
import com.jwt.example.dto.SignUpRequest;
import com.jwt.example.model.Role;
import com.jwt.example.model.User;
import com.jwt.example.repository.UserRepository;
import com.jwt.example.services.AuthenticationService;
import com.jwt.example.services.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
private final UserRepository userRepository;

private final PasswordEncoder passwordEncoder;

private final AuthenticationManager authenticationManager;

private final JWTService jwtService;

public User signup(SignUpRequest  signUpRequest){
    User user = new User();

    user.setEmail(signUpRequest.getEmail());
    user.setFirstName(signUpRequest.getFirstName());
    user.setLastName(signUpRequest.getLastName());
    user.setRole(Role.USER);
    user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));

    return userRepository.save(user);
}

public JwtAuthenticationResponse signin(SignInRequest signInRequest){
    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInRequest.getEmail(),
            signInRequest.getPassword()));

    var user = userRepository.findByEmail(signInRequest.getEmail()).orElseThrow(()->new IllegalArgumentException("Invalid email and password"));

    var jwt = jwtService.generateToken((UserDetails) user);

    var refreshToken = jwtService.generateRefreshToken(new HashMap<>(), (UserDetails) user);

    JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();
    jwtAuthenticationResponse.setToken(jwt);
    jwtAuthenticationResponse.setRefreshToken(refreshToken);
    return jwtAuthenticationResponse;
}

 public JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest){
    String userEmail = jwtService.extractUserName(refreshTokenRequest.getToken());
    User user = (User) userRepository.findByEmail(userEmail).orElseThrow();
    if(jwtService.isTokenValid(refreshTokenRequest.getToken(), user)){
        var jwt = jwtService.generateToken(user);

        JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();
        jwtAuthenticationResponse.setToken(jwt);
        jwtAuthenticationResponse.setRefreshToken(refreshTokenRequest.getToken());
        return jwtAuthenticationResponse;
    }
    return null;
 }
}
