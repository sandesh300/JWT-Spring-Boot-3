package com.jwt.example.services.impl;

import com.jwt.example.repository.UserRepository;
import com.jwt.example.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserDetailsService userDetailsService(){
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username)  {
                return (UserDetails) userRepository.findByMail(username)
                        .orElseThrow(()-> new UsernameNotFoundException("User not found"));
            }
        };
    }
}
