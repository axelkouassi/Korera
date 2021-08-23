package com.itlize.korera.service.serviceimpl;

import com.itlize.korera.model.Column;
import com.itlize.korera.model.ColumnType;
import com.itlize.korera.model.Resource;
import com.itlize.korera.repository.ColumnRepository;
import com.itlize.korera.repository.ResourceRepository;
import com.itlize.korera.repository.UserRepository;
import com.itlize.korera.service.ColumnService;
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
public class ColumnServiceImpl implements ColumnService {

    @Autowired
    private final ColumnRepository columnRepository;
    @Autowired
    private final ResourceRepository resourceRepository;
    @Override
    public boolean columnContentExists(String content) {
        return columnRepository.existsByContent(content);
    }

    @Override
    public boolean columnTypeExists(ColumnType type) {
        return columnRepository.existsByColumnType(type);
    }

    @Override
    public boolean columnIdExists(Integer id) {
        return columnRepository.existsById(id);
    }

    @Override
    public Column saveColumn(Column column) {
        log.info("Creating column " + column.getContent() + "...");
        column.setTimeCreated(LocalDateTime.now());
        column.setTimeUpdated(LocalDateTime.now());
        log.info("Column " + column.getContent() + " has been created and saved to the database.");
        return columnRepository.save(column);
    }

    @Override
    public Column findByContent(String content) {
        log.info("Fetching column with content: " + content + "...");
        Column column =  columnRepository.findByContent(content).orElse(null);
        if(column == null){
            throw new NullPointerException("Column content: " + content
                    + " was not found in the database.");
        }
        log.info("Column info: " + column);
        return column;
    }

    @Override
    public Column findById(Integer id) {
        log.info("Fetching column with id: " + id + "...");
        Column column =  columnRepository.findById(id).orElse(null);
        if(column == null){
            throw new NullPointerException("Column with id: " + id
                    + " was not found in the database.");
        }
        log.info("Column info: " + column);
        return column;
    }

    @Override
    public List<Column> findColumnsByType(ColumnType type) {
        log.info("Fetching list of columns with type: " + type.name() + "...");
        if(!columnRepository.existsByColumnType(type)){
            throw new NullPointerException("Column type : " + type.name()
                    + " was not found in the database.");
        }
        List<Column> list = columnRepository.findAllByColumnType(type);
        log.info("List of columns with type " + type + ": " + list);
        return columnRepository.findAllByColumnType(type);
    }


    @Override
    public List<Column> getColumsByResource(String resourceName) {
        return columnRepository.findAllByResource_ResourceName(resourceName);
    }

    @Override
    public List<Column> getColumns() {
        return columnRepository.findAll();
    }

    @Override
    public Column updateContent(Column column, String content) {
        log.info("Updating content " + column.getContent() + " to " + content);
        column.setContent(content);
        column.setTimeUpdated(LocalDateTime.now());
        log.info("Column content " + column.getContent() + " has been updated to " + content);
        log.info("Column: " + column);
        return column;
    }

    @Override
    public Column updateType(Column column, ColumnType type) {
        log.info("Updating column's type " + column.getColumnType() + " to " + type);
        column.setColumnType(type);
        column.setTimeUpdated(LocalDateTime.now());
        log.info("Column's type " + column.getColumnType() + " has been updated to " + type);
        log.info("Column: " + column);
        return column;
    }

    @Override
    public Column updateResource(String content, String resourceName) {

        log.info("Associating column with content " + content + "  to resource with name " + resourceName);

        log.info("Finding column with content " + content + "...");
        Column column =  columnRepository.findByContent(content).orElse(null);
        log.info("Column info: " + column);

        log.info("Finding resource with name " + resourceName + "...");
        Resource resource =  resourceRepository.findByResourceName(resourceName).orElse(null);
        log.info("Resource info: " + resource);

        if(column == null){
            throw new NullPointerException("Column with content: " + content
                    + " was not found in the database.");
        }else if(resource == null){
            throw new NullPointerException("Resource with name: " +
                    resourceName + " was not found in the database.");
        }else{
            column.setResource(resource);
            log.info("Column's info after update operation: " + column);
        }

        return column;
    }

    @Override
    public void deleteByContent(String content) {
        columnRepository.deleteByContent(content);
    }

    @Override
    public void deleteByType(ColumnType type) {
        columnRepository.deleteByColumnType(type);
    }

    @Override
    public void deleteById(Integer id) {
        columnRepository.deleteById(id);
    }

    @Override
    public void deleteColumns() {
        columnRepository.deleteAll();
    }
}
