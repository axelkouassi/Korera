package com.itlize.korera.repository;

import com.itlize.korera.model.ProjectResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectResourceRepository extends JpaRepository<ProjectResource,Integer> {
    ProjectResource findByProject_ProjectName(String projectName);
    ProjectResource findByResource_ResourceName(String resourceName);
}
