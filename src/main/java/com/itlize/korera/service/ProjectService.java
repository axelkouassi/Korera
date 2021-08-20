package com.itlize.korera.service;

import com.itlize.korera.model.Project;
import com.itlize.korera.model.Resource;
import com.itlize.korera.model.User;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    boolean projectNameExists(String name);
    boolean projectIdExists(Integer id);
    Project saveProject(Project project);
    Project findByName(String name);
    Project findById(Integer id);
    List<Project> getProjectsByUsername(String username);
    List<Project> getProjects();
    Project updateName(Project project, String name);
    void deleteByProjectName(String name);
    void deleteByProjectId(Integer projectId);
    void deleteProjects();
}
