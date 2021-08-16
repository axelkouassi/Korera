package com.itlize.korera.repository;

import com.itlize.korera.model.Resource;
import com.itlize.korera.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResourceRepository extends JpaRepository<Resource,Integer> {
    Optional<Resource> findByResourceName(String resourceName);
    Optional<Resource> findByResourceCode(String resourceCode);
    void deleteByResourceName(String resourceName);
    void deleteByResourceCode(String resourceCode);
}
