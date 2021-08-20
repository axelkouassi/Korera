package com.itlize.korera.service.serviceimpl;

import com.itlize.korera.model.Project;
import com.itlize.korera.model.Resource;
import com.itlize.korera.repository.ResourceRepository;
import com.itlize.korera.repository.UserRepository;
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

    }
}
