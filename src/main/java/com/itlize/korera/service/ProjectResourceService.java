package com.itlize.korera.service;

import com.itlize.korera.model.*;

import java.util.List;

public interface ProjectResourceService {
    boolean projectResourceIdExists(Integer id);
    ProjectResource saveProjectResource(ProjectResource projectResource);
    ProjectResource addResourceToProject(Project project, Resource resource);
    ProjectResource findById(Integer id);
    List<ProjectResource> findByProject(String projectName);
    List<ProjectResource> findByResource(String resourceName);
    List<ProjectResource> getProjectResources();
    ProjectResource updateProject(Integer projectResourceId, String projectName);
    ProjectResource updateResource(Integer projectResourceId, String resourceName);
    void deleteById(Integer id);
    void deleteByProject(String projectName);
    void deleteByResource(String resourceName);
    void deleteProjectResources();

}
