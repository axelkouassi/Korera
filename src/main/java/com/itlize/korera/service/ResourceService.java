package com.itlize.korera.service;

import com.itlize.korera.model.Project;
import com.itlize.korera.model.Resource;
import com.itlize.korera.model.User;

import java.util.List;
import java.util.Optional;

public interface ResourceService {
    boolean resourceNameExists(String name);
    boolean resourceCodeExists(String code);
    boolean resourceIdExists(Integer id);
    Resource saveResource(Resource resource);
    Resource findByName(String name);
    Resource findByCode(String code);
    Resource findById(Integer id);
    List<Resource> getResourcesByProject(Project project);
    List<Resource> getResources();
    Project updateName(Project project, String name);
    Project updateCode(Project project, String code);
    void deleteByName(String name);
    void deleteByCode(String code);
    void deleteById(Integer id);
    void deleteResources();
}
