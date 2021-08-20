package com.itlize.korera.repository;

import com.itlize.korera.model.Project;
import com.itlize.korera.model.User;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class ProjectRepositoryTest {

    @Autowired
    UserRepository userRepository;
    @Autowired
    ProjectRepository projectRepository;

    //Create Project
    @Test
    public void createProjectTest(){

        //Existing user
        Integer userId = 1;
        User user;
        user = userRepository.getById(userId);

        //Create new project
        Project project = new Project();
        project.setProjectName("Project 1");
        project.setUser(user);
        project.setTimeCreated(LocalDateTime.now());
        project.setTimeUpdated(LocalDateTime.now());

        Project projectTest = projectRepository.save(project);

        boolean doesProjectExists = projectRepository.existsById(projectTest.getProjectId());

        assertNotNull(projectTest);
        //assertTrue(doesProjectExists);
        //assertEquals(project, projectTest);
    }

    //Read Project
    @Test
    public void readProjectByIdTest(){
        Integer projectId = 1;

        boolean IsProjectExists = projectRepository.existsById(projectId);

        assertTrue(IsProjectExists);
    }

    //Update project
    @Test
    public void updateProjectByIdTest(){
        Integer projectId= 1;
        Project expected = projectRepository.getById(projectId);
        expected.setProjectName("Project1");
        expected.setTimeUpdated(LocalDateTime.now());

        Project actual = projectRepository.save(expected);

        assertEquals("Project1", actual.getProjectName());
    }

    //Delete Project
    @Test
    public void deleteProjectByIdTest(){

        Integer projectId= 1;

        projectRepository.deleteById(projectId);

        boolean actual = projectRepository.existsById(projectId);

        assertFalse(actual);
    }

    @Test
    void findByProjectName() {
        String name = "project1";
        boolean actual = projectRepository.existsByProjectName(name);
        assertTrue(actual);
        Project project;
        project = new Project();
        if(projectRepository.findByProjectName(name).isPresent()) {
            project = projectRepository.findByProjectName(name).get();
        }
        assertEquals(name,project.getProjectName());
    }

    @Test
    void deleteByProjectName() {
    }
}