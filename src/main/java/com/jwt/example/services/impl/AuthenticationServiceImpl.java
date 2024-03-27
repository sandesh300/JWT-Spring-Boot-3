package com.jwt.example.services.impl;

import com.jwt.example.dto.SignUpRequest;
import com.jwt.example.model.Role;
import com.jwt.example.model.User;
import com.jwt.example.repository.UserRepository;
import com.jwt.example.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
private final UserRepository userRepository;

private final PasswordEncoder passwordEncoder;

public User signup(SignUpRequest  signUpRequest){
    User user = new User();

    user.setEmail(signUpRequest.getEmail());
    user.setFirstName(signUpRequest.getFirstName());
    user.setLastName(signUpRequest.getLastName());
    user.setRole(Role.USER);
    user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));

    return userRepository.save(user);
}
}
