package com.itlize.korera.service.serviceimpl;

import com.itlize.korera.model.Project;
import com.itlize.korera.model.ProjectResource;
import com.itlize.korera.model.Resource;
import com.itlize.korera.repository.ProjectRepository;
import com.itlize.korera.repository.ProjectResourceRepository;
import com.itlize.korera.repository.ResourceRepository;
import com.itlize.korera.repository.UserRepository;
import com.itlize.korera.service.ProjectResourceService;
import com.itlize.korera.service.ResourceService;
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
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    private final ResourceRepository resourceRepository;
    @Autowired
    private final ProjectRepository projectRepository;

    @Autowired
    private final ProjectResourceRepository projectResourceRepository;

    @Override
    public boolean resourceNameExists(String name) {
        return resourceRepository.findByResourceName(name).isPresent();
    }

    @Override
    public boolean resourceCodeExists(String code) {
        return resourceRepository.findByResourceCode(code).isPresent();
    }

    @Override
    public boolean resourceIdExists(Integer id) {
        return resourceRepository.existsById(id);
    }

    @Override
    public Resource saveResource(Resource resource) {
        resource.setTimeCreated(LocalDateTime.now());
        resource.setTimeUpdated(LocalDateTime.now());
        return resourceRepository.save(resource);
    }

    @Override
    public ProjectResource addResourceToProject(String resourceName, String projectName) {
        Resource resource = resourceRepository.findByResourceName(resourceName).orElse(null);
        Project project = projectRepository.findByProjectName(projectName).orElse(null);
        ProjectResource projectResource = new ProjectResource();
        projectResource.setResource(resource);
        projectResource.setProject(project);
        projectResource.setTimeCreated(LocalDateTime.now());
        projectResource.setTimeUpdated(LocalDateTime.now());
        projectResourceRepository.save(projectResource);

        return projectResource;
    }

    @Override
    public Resource findByName(String name) {
        log.info("Fetching resource with name: " + name + "...");
        Resource resource =  resourceRepository.findByResourceName(name).orElse(null);
        if(resource== null){
            throw new NullPointerException("Resource name: " + name + " was not found in the database.");
        }
        log.info("Resource " + name + " info: " + resource);
        return resource;
    }

    @Override
    public Resource findByCode(String code) {
        log.info("Fetching resource with code: " + code + "...");
        Resource resource =  resourceRepository.findByResourceCode(code).orElse(null);
        if(resource== null){
            throw new NullPointerException("Resource code : " + code + " was not found in the database.");
        }
        log.info("Resource " + code + " info: " + resource);
        return resource;
    }

    @Override
    public Resource findById(Integer id) {
        log.info("Fetching resource with id: " + id + "...");
        Resource resource =  resourceRepository.findById(id).orElse(null);
        if(resource== null){
            throw new NullPointerException("Resource id : " + id + " was not found in the database.");
        }
        log.info("Resource " + id + " info: " + resource);
        return resource;
    }

    @Override
    public List<ProjectResource> getResourcesByProject(String projectName) {
        log.info("Fetching list of resources based on project...");
        List<ProjectResource> list = projectResourceRepository.findByProject_ProjectName(projectName);
        log.info("List of all resources: " + list);
        return projectResourceRepository.findByProject_ProjectName(projectName);
    }

    @Override
    public List<ProjectResource> getProjectsByResource(String resourceName) {
        log.info("Fetching list of projects based on resources...");
        List<ProjectResource> list = projectResourceRepository.findByResource_ResourceName(resourceName);
        log.info("List of all projects: " + list);
        return projectResourceRepository.findByResource_ResourceName(resourceName);
    }

    @Override
    public List<Resource> getResources() {
        log.info("Fetching list of projects...");
        List<Resource> list = resourceRepository.findAll();
        log.info("List of all projects: " + list);
        return resourceRepository.findAll();
    }

    @Override
    public Resource updateName(Resource resource, String name) {
        log.info("Updating resource name to " + name);
        resource.setResourceName(name);
        log.info("Resource name " + name + ": " + resource);
        return resource;
    }

    @Override
    public Resource updateCode(Resource resource, String code) {
        log.info("Updating resource code to " + code);
        resource.setResourceCode(code);
        log.info("Resource code " + code + ": " + resource);
        return resource;
    }

    @Override
    public Project updateCode(Project project, String code) {
        return null;
    }

    @Override
    public ProjectResource updateProject(Integer projectResourceId, String projectName) {
        Project project = projectRepository.findByProjectName(projectName).orElse(null);
        ProjectResource projectResource = projectResourceRepository.findById(projectResourceId).orElse(null);
        if (projectResource != null) {
            projectResource.setProject(project);
        }
        if (projectResource != null) {
            projectResource.setTimeUpdated(LocalDateTime.now());
        }
        return null;
    }

    @Override
    public void deleteByName(String name) {
        resourceRepository.deleteByResourceName(name);
    }

    @Override
    public void deleteByCode(String code) {
        resourceRepository.deleteByResourceCode(code);
    }

    @Override
    public void deleteById(Integer id) {
        resourceRepository.deleteById(id);
    }

    @Override
    public void deleteResources() {
        resourceRepository.deleteAll();
    }
}
