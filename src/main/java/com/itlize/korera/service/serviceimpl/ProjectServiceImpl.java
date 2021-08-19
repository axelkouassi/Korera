package com.itlize.korera.service.serviceimpl;

import com.itlize.korera.model.Project;
import com.itlize.korera.model.User;
import com.itlize.korera.service.ProjectService;

import java.util.List;

public class ProjectServiceImpl implements ProjectService {
    @Override
    public boolean projectNameExists(String username) {
        return false;
    }

    @Override
    public boolean projectIdExists(Integer projectId) {
        return false;
    }

    @Override
    public Project saveProject(Project project) {
        return null;
    }

    @Override
    public Project findByName(String projectName) {
        return null;
    }

    @Override
    public Project findById(Integer projectId) {
        return null;
    }

    @Override
    public List<Project> getProjectsByUser(User user) {
        return null;
    }

    @Override
    public List<Project> getProjects() {
        return null;
    }

    @Override
    public Project updateName(Project project, String name) {
        return null;
    }

    @Override
    public void deleteByProjectName(String projectName) {

    }

    @Override
    public void deleteByProjectId(Integer projectId) {

    }

    @Override
    public void deleteProjects() {

    }
}
