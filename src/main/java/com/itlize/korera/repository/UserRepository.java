package com.itlize.korera.repository;

import com.itlize.korera.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
    void deleteByUsername(String username);
    boolean existsByUsername(String username);
}
