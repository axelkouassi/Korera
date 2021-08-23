package com.itlize.korera.service;

import com.itlize.korera.model.*;

import java.util.List;

public interface ProjectResourceService {
    ProjectResource findById(Integer id);
    List<ProjectResource> getProjectResources();

    boolean projectResourceIdExists(Integer id);
    ProjectResource saveProjectResource(ProjectResource projectResource);
    ProjectResource addResourceToProject(Project project, Resource resource);

    ProjectResource findProjectResourceByProjectName(String projectName);
    ProjectResource findProjectResourceByResourceName(String resourceName);
    Project findProjectByProjectResourceId(Integer projectResourceId);
    Resource findResourceByProjectResourceId(Integer projectResourceId);
    List<Resource> getResourcesByProject(Project project);
    List<Project> getProjectsByResource(Resource resource);
    ProjectResource updateProject(Project project);
    ProjectResource updateResource(Resource resource);
    void deleteResourceFromProject(Project project, Resource resource);
    void deleteById(Integer id);
    void deleteProjectResources();
}
