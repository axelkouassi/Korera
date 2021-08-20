package com.itlize.korera.service.serviceimpl;

import com.itlize.korera.model.Project;
import com.itlize.korera.model.User;
import com.itlize.korera.repository.ProjectRepository;
import com.itlize.korera.repository.UserRepository;
import com.itlize.korera.service.ProjectService;
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
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final ProjectRepository projectRepository;
    @Override
    public boolean projectNameExists(String name) {
        return false;
    }

    @Override
    public boolean projectIdExists(Integer id) {
        return false;
    }

    @Override
    public Project saveProject(Project project) {
        log.info("Creating project " + project.getProjectName() + "...");
        project.setTimeCreated(LocalDateTime.now());
        project.setTimeUpdated(LocalDateTime.now());
        log.info("Project " + project.getProjectName() + " has been created and saved to the database.");
        return projectRepository.save(project);
    }

    @Override
    public Project findByName(String name) {
        return null;
    }

    @Override
    public Project findById(Integer id) {
        return null;
    }

    @Override
    public List<Project> getProjectsByUser(User user) {
        return null;
    }

    @Override
    public List<Project> getProjects() {
        return null;
    }

    @Override
    public Project updateName(Project project, String name) {
        return null;
    }

    @Override
    public void deleteByProjectName(String name) {

    }

    @Override
    public void deleteByProjectId(Integer id) {

    }

    @Override
    public void deleteProjects() {

    }
}
