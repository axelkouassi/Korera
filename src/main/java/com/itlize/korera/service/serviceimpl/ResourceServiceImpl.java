package com.itlize.korera.service.serviceimpl;

import com.itlize.korera.model.Project;
import com.itlize.korera.model.Resource;
import com.itlize.korera.service.ResourceService;

import java.util.List;

public class ResourceServiceImpl implements ResourceService {
    @Override
    public boolean resourceNameExists(String name) {
        return false;
    }

    @Override
    public boolean resourceCodeExists(String code) {
        return false;
    }

    @Override
    public boolean resourceIdExists(Integer id) {
        return false;
    }

    @Override
    public Resource saveResource(Resource resource) {
        return null;
    }

    @Override
    public Resource findByName(String name) {
        return null;
    }

    @Override
    public Resource findByCode(String code) {
        return null;
    }

    @Override
    public Resource findById(Integer id) {
        return null;
    }

    @Override
    public List<Resource> getResourcesByProject(Project project) {
        return null;
    }

    @Override
    public List<Resource> getResources() {
        return null;
    }

    @Override
    public Project updateName(Project project, String name) {
        return null;
    }

    @Override
    public Project updateCode(Project project, String code) {
        return null;
    }

    @Override
    public void deleteByName(String name) {

    }

    @Override
    public void deleteByCode(String code) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void deleteResources() {

    }
}
