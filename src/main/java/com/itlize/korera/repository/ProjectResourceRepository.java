package com.itlize.korera.repository;

import com.itlize.korera.model.Project;
import com.itlize.korera.model.ProjectResource;
import com.itlize.korera.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectResourceRepository extends JpaRepository<ProjectResource,Integer> {
    List<ProjectResource> findByProject_ProjectName(String projectName);
    List<ProjectResource> findByResource_ResourceName(String resourceName);
    ProjectResource findByProject(Project project);
    void deleteByProject_ProjectName(String projectName);
    void deleteByResource_ResourceName(String resourceName);

}
