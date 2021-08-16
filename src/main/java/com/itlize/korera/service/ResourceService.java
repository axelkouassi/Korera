package com.itlize.korera.service;

import com.itlize.korera.model.Resource;
import com.itlize.korera.model.User;

import java.util.List;
import java.util.Optional;

public interface ResourceService {
    Resource saveResource(Resource resource);
    Optional<Resource> findByResourceName(String resourceName);
    List<Resource> getResources();
    void deleteByResourceName(String resourceName);
    void deleteResources();
}
