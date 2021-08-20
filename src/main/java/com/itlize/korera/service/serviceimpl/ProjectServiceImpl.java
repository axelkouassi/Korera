package com.itlize.korera.service.serviceimpl;

import com.itlize.korera.model.Project;
import com.itlize.korera.model.User;
import com.itlize.korera.repository.ProjectRepository;
import com.itlize.korera.repository.UserRepository;
import com.itlize.korera.service.ProjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
        return projectRepository.existsByProjectName(name);
    }

    @Override
    public boolean projectIdExists(Integer id) {
        return projectRepository.existsById(id);
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
        log.info("Fetching project with name: " + name + "...");
        Project project =  projectRepository.findByProjectName(name).orElse(null);
        if(project == null){
            throw new NullPointerException("Project name: " + name + " was not found in the database.");
        }
        return project;
    }

    @Override
    public Project findById(Integer id) {
        log.info("Fetching project with id: " + id + "...");
        Project project =  projectRepository.findById(id).orElse(null);
        if(project == null){
            throw new NullPointerException("Project id: " + id + " was not found in the database.");
        }
        return project;
    }

    @Override
    public List<Project> getProjectsByUsername(String username) {
        log.info("Fetching projects by username: " + username + "...");
        List<Project> list = projectRepository.findAllByUser_Username(username);
        log.info("List of all projects associated with user " + username + ": " + list);
        return projectRepository.findAllByUser_Username(username);
    }

    @Override
    public List<Project> getProjects() {
        log.info("Fetching list of projects...");
        List<Project> list = projectRepository.findAll();
        log.info("List of all projects: " + list);
        return projectRepository.findAll();
    }

    @Override
    public Project updateUser(String name, String username) {
        log.info("Updating user associated with project " + name + "  to " + username);
        User user = userRepository.findByUsername(username).orElse(null);
        Project project = projectRepository.findByProjectName(name).orElse(null);
        if(user == null){
            throw new UsernameNotFoundException("Username: " + username + " was not found in the database.");
        }else if(project == null){
            throw new NullPointerException("Project: " + name + " was not found in the database.");
        }else{
            project.setUser(user);
            log.info("Project " + name + ": " + project);
        }
        return project;
    }

    @Override
    public Project updateName(Project project, String name) {
        log.info("Updating project name to " + name);
        project.setProjectName(name);
        log.info("Project " + name + ": " + project);
        return project;
    }

    @Override
    public void deleteByProjectName(String name) {
        log.info("Deleting project " + name + "...");
        projectRepository.deleteByProjectName(name);
        log.info("Project with name " + name + " has been successfully deleted.");
    }

    @Override
    public void deleteByProjectId(Integer id) {
        log.info("Deleting project with id " + id + "...");
        projectRepository.deleteById(id);
        log.info("Project with id " + id + " has been successfully deleted.");

    }

    @Override
    public void deleteProjects() {
        log.info("Deleting all projects...");
        projectRepository.deleteAll();
        log.info("All projects have been successfully deleted.");
    }
}
