package com.itlize.korera.service.serviceimpl;

import com.itlize.korera.model.Project;
import com.itlize.korera.model.ProjectResource;
import com.itlize.korera.model.Resource;
import com.itlize.korera.service.ProjectResourceService;

import java.util.List;

public class ProjectResourceServiceImpl implements ProjectResourceService {
    @Override
    public boolean projectResourceIdExists(Integer id) {
        return false;
    }

    @Override
    public ProjectResource saveProjectResource(ProjectResource projectResource) {
        return null;
    }

    @Override
    public ProjectResource addResourceToProject(Project project, Resource resource) {
        return null;
    }

    @Override
    public ProjectResource findById(Integer id) {
        return null;
    }

    @Override
    public ProjectResource findProjectResourceByProject(Project project) {
        return null;
    }

    @Override
    public ProjectResource findProjectResourceByResource(Resource resource) {
        return null;
    }

    @Override
    public Project findProjectByProjectResourceId(Integer projectResourceId) {
        return null;
    }

    @Override
    public Resource findResourceByProjectResourceId(Integer projectResourceId) {
        return null;
    }

    @Override
    public List<ProjectResource> getProjectResources() {
        return null;
    }

    @Override
    public List<Resource> getResourcesByProject(Project project) {
        return null;
    }

    @Override
    public List<Project> getProjectsByResource(Resource resource) {
        return null;
    }

    @Override
    public ProjectResource updateProject(Project project) {
        return null;
    }

    @Override
    public ProjectResource updateResource(Resource resource) {
        return null;
    }

    @Override
    public void deleteResourceFromProject(Project project, Resource resource) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void deleteProjectResources() {

    }
}
