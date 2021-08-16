package com.itlize.korera.service;

import com.itlize.korera.model.Project;
import com.itlize.korera.model.Resource;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    Project saveProject(Project project);
    Optional<Project> findByProjectName(String projectName);
    List<Project> getProjects();
    void deleteByProjectName(String projectName);
    void deleteProjects();
}
