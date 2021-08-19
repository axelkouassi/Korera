package com.itlize.korera.service;

import com.itlize.korera.model.Project;
import com.itlize.korera.model.Resource;
import com.itlize.korera.model.User;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    boolean projectNameExists(String username);
    boolean projectIdExists(Integer projectId);
    Project saveProject(Project project);
    Project findByName(String projectName);
    Project findById(Integer projectId);
    List<Project> getProjectsByUser(User user);
    List<Project> getProjects();
    Project updateName(Project project, String name);
    void deleteByProjectName(String projectName);
    void deleteByProjectId(Integer projectId);
    void deleteProjects();
}
