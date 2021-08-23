package com.itlize.korera.service.serviceimpl;

import com.itlize.korera.model.Project;
import com.itlize.korera.model.ProjectResource;
import com.itlize.korera.model.Resource;
import com.itlize.korera.repository.ProjectRepository;
import com.itlize.korera.repository.ProjectResourceRepository;
import com.itlize.korera.repository.ResourceRepository;
import com.itlize.korera.repository.UserRepository;
import com.itlize.korera.service.ProjectResourceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j // logs
public class ProjectResourceServiceImpl implements ProjectResourceService {

    @Autowired
    private final ProjectResourceRepository projectResourceRepository;
    @Autowired
    private final ResourceRepository resourceRepository;
    @Autowired
    private final ProjectRepository projectRepository;

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
    public List<ProjectResource> findByProject(String projectName) {
        return projectResourceRepository.findByProject_ProjectName(projectName);
    }

    @Override
    public List<ProjectResource> findByResource(String resourceName) {
        return projectResourceRepository.findByResource_ResourceName(resourceName);
    }

    @Override
    public List<ProjectResource> getProjectResources() {
        return projectResourceRepository.findAll();
    }

    @Override
    public ProjectResource updateProject(Integer projectResourceId, String projectName) {
        ProjectResource projectResource = projectResourceRepository.findById(projectResourceId).orElse(null);
        Project project = projectRepository.findByProjectName(projectName).orElse(null);
        if (projectResource != null) {
            projectResource.setProject(project);
        }
        if (projectResource != null) {
            projectResource.setTimeUpdated(LocalDateTime.now());
        }
        return projectResource;
    }

    @Override
    public ProjectResource updateResource(Integer projectResourceId, String resourceName) {
        ProjectResource projectResource = projectResourceRepository.findById(projectResourceId).orElse(null);
        Resource resource = resourceRepository.findByResourceName(resourceName).orElse(null);
        if (projectResource != null) {
            projectResource.setResource(resource);
        }
        if (projectResource != null) {
            projectResource.setTimeUpdated(LocalDateTime.now());
        }
        return projectResource;
    }

    @Override
    public void deleteById(Integer id) {
        projectResourceRepository.findById(id);

    }

    @Override
    public void deleteByProject(String projectName) {
        projectResourceRepository.deleteByProject_ProjectName(projectName);

    }

    @Override
    public void deleteByResource(String resourceName) {
        projectResourceRepository.deleteByResource_ResourceName(resourceName);
    }

    @Override
    public void deleteProjectResources() {
        projectResourceRepository.deleteAll();
    }
}
