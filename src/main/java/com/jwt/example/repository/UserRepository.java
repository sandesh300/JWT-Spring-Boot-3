package com.jwt.example.repository;

import com.jwt.example.model.Role;
import com.jwt.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<Object> findByEmail(String email);

    User findByRole(Role role);
}
