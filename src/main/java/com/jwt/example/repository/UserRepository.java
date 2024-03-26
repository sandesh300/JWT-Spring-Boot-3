package com.jwt.example.repository;

import com.jwt.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<Object> findByMail(String email);
}
