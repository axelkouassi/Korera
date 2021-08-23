package com.itlize.korera.service.serviceimpl;

import com.itlize.korera.model.Project;
import com.itlize.korera.model.ProjectResource;
import com.itlize.korera.model.Resource;
import com.itlize.korera.repository.ProjectResourceRepository;
import com.itlize.korera.repository.UserRepository;
import com.itlize.korera.service.ProjectResourceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j // logs
public class ProjectResourceServiceImpl implements ProjectResourceService {

    @Autowired
    private final ProjectResourceRepository projectResourceRepository;
    @Override
    public boolean projectResourceIdExists(Integer id) {
        return projectResourceRepository.existsById(id);
    }

    @Override
    public ProjectResource saveProjectResource(ProjectResource projectResource) {
        return projectResourceRepository.save(projectResource);
    }

    @Override
    public ProjectResource addResourceToProject(Project project, Resource resource) {
        ProjectResource projectResource = new ProjectResource();
        projectResource.setProject(project);
        projectResource.setResource(resource);
        return projectResourceRepository.save(projectResource);
    }

    @Override
    public ProjectResource findById(Integer id) {
        return projectResourceRepository.findById(id).orElse(null);
    }

    @Override
    public ProjectResource findProjectResourceByProjectName(String projectName) {
        return null;
    }

    @Override
    public ProjectResource findProjectResourceByResourceName(String resourceName) {
        return projectResourceRepository.findByResource_ResourceName(resourceName);
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
        return projectResourceRepository.findAll();
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
