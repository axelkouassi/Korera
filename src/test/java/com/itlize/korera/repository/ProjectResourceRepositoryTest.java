package com.itlize.korera.repository;

import com.itlize.korera.model.Project;
import com.itlize.korera.model.ProjectResource;
import com.itlize.korera.model.Resource;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProjectResourceRepositoryTest {

    @Autowired
    ProjectResourceRepository projectResourceRepository;
    @Autowired
    ResourceRepository resourceRepository;
    @Autowired
    ProjectRepository projectRepository;


    //Create ProjectResource
    @Test
    public void createProjectResourceTest(){

        //Existing project
        Integer projectId = 26;
        Project project = projectRepository.getById(projectId);


        //Existing resource
        Integer resourceId = 29;
        Resource resource = resourceRepository.getById(resourceId);

        //Create new resource
        ProjectResource projectResource = new ProjectResource();
        projectResource.setProject(project);
        projectResource.setResource(resource);
        projectResource.setTimeCreated(LocalDateTime.now());
        projectResource.setTimeUpdated(LocalDateTime.now());

        ProjectResource projectResourceTest = projectResourceRepository.save(projectResource);

        boolean doesProjectResourceExists = projectResourceRepository.existsById(projectResource.getProjectResourceId());

        Assert.assertNotNull(projectResourceTest);
        Assert.assertTrue(doesProjectResourceExists);
        Assert.assertEquals(projectResource, projectResourceTest);
    }

    //Read ProjectResource
    @Test
    public void readProjectResourceByIdTest(){
        Integer projectResourceId = 1;

        boolean doesProjectResourceExists = projectResourceRepository.existsById(projectResourceId);

        Assert.assertTrue(doesProjectResourceExists);
    }


    //Delete Resource
    @Test
    public void deleteProjectResourceByIdTest(){

        Integer projectResourceId= 1;

        projectResourceRepository.deleteById(projectResourceId);

        boolean actual = projectResourceRepository.existsById(projectResourceId);

        Assert.assertFalse(actual);
    }

}