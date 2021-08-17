package com.itlize.korera.service;

import com.itlize.korera.model.Project;
import com.itlize.korera.model.ProjectResource;
import com.itlize.korera.model.Resource;

import java.util.List;

public interface ProjectResourceService {
    void addResourceToProject(Project project, Resource resource);
    ProjectResource getProjectResourceById(Integer projectResourceId);
    List<Resource> getProjectResources(String projectId);
    List<Project> getProjectsUsingResource(String resourceId);
    void removeResourceFromProject(Resource resource);
    void deleteAll();
}
