package com.itlize.korera.repository;

import com.itlize.korera.model.Project;
import com.itlize.korera.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project,Integer> {
    Optional<Project> findByProjectName(String projectName);
    void deleteByProjectName(String projectName);
}
