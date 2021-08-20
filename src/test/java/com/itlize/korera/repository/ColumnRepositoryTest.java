package com.itlize.korera.repository;

import com.itlize.korera.model.Column;
import com.itlize.korera.model.ColumnType;
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
class ColumnRepositoryTest {

    @Autowired
    ColumnRepository columnRepository;
    @Autowired
    ResourceRepository resourceRepository;

    //Create Column
    @Test
    public void createColumnTest(){

        //Existing resource
        Integer resourceId = 2;
        Resource resource = resourceRepository.getById(resourceId);

        //Create new column
        Column column = new Column();
        column.setContent("Quantity");
        column.setColumnType(ColumnType.NUMBER);
        column.setTimeCreated(LocalDateTime.now());
        column.setTimeUpdated(LocalDateTime.now());
        column.setResource(resource);

        Column columnTest = columnRepository.save(column);

        boolean doesColumnExists = columnRepository.existsById(column.getColumnId());

        Assert.assertNotNull(columnTest);
        Assert.assertTrue(doesColumnExists);
        Assert.assertEquals(column, columnTest);
    }

    //Read Column
    @Test
    public void readColumnByIdTest(){
        Integer columnId = 3;

        boolean doesColumnExists = columnRepository.existsById(columnId);

        Assert.assertTrue(doesColumnExists);
    }

    //Update Column
    @Test
    public void updateColumnByIdTest(){
        Integer columnId= 3;
        Column expected = columnRepository.getById(columnId);
        expected.setContent("Quantity1");
        expected.setTimeUpdated(LocalDateTime.now());

        Column actual = columnRepository.save(expected);

        Assert.assertEquals("Quantity1", actual.getContent());
    }

    //Delete Column
    @Test
    public void deleteColumnByIdTest(){

        Integer columnId= 3;

        columnRepository.deleteById(columnId);

        boolean actual = columnRepository.existsById(columnId);

        Assert.assertFalse(actual);
    }

}