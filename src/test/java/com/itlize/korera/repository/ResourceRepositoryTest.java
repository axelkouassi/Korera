package com.itlize.korera.repository;

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
public class ResourceRepositoryTest {
    @Autowired
    ResourceRepository resourceRepository;

    //Create Resource
    @Test
    public void createResourceTest(){

        //Create new resource
        Resource resource = new Resource();
        resource.setResourceName("Resource2");
        resource.setResourceCode("01 00 00");
        resource.setTimeCreated(LocalDateTime.now());
        resource.setTimeUpdated(LocalDateTime.now());

        Resource resourceTest = resourceRepository.save(resource);

        boolean doesResourceExists = resourceRepository.existsById(resource.getResourceId());

        Assert.assertNotNull(resourceTest);
        Assert.assertTrue(doesResourceExists);
        Assert.assertEquals(resource, resourceTest);
    }

    //Read Resource
    @Test
    public void readResourceByIdTest(){
        Integer resourceId = 1;

        boolean doesResourceExists = resourceRepository.existsById(resourceId);

        Assert.assertTrue(doesResourceExists);
    }

    //Update Resource
    @Test
    public void updateResourceByIdTest(){
        Integer resourceId= 1;
        Resource expected = resourceRepository.getById(resourceId);
        expected.setResourceName("Resource1");
        expected.setTimeUpdated(LocalDateTime.now());

        Resource actual = resourceRepository.save(expected);

        Assert.assertEquals("Resource1", actual.getResourceName());
    }

    //Delete Resource
    @Test
    public void deleteResourceByIdTest(){

        Integer resourceId= 1;

        resourceRepository.deleteById(resourceId);

        boolean actual = resourceRepository.existsById(resourceId);

        Assert.assertFalse(actual);
    }

}