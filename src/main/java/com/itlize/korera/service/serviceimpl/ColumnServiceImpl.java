package com.itlize.korera.service.serviceimpl;

import com.itlize.korera.model.Column;
import com.itlize.korera.model.ColumnType;
import com.itlize.korera.model.Project;
import com.itlize.korera.model.Resource;
import com.itlize.korera.repository.ColumnRepository;
import com.itlize.korera.repository.ProjectRepository;
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
    private final UserRepository userRepository;
    @Autowired
    private final ColumnRepository columnRepository;
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
        return false;
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
    public Column findById(Integer id) {
        return null;
    }

    @Override
    public List<Column> getColumsByResource(Resource resource) {
        return null;
    }

    @Override
    public List<Column> getColumns() {
        return null;
    }

    @Override
    public Column updateContent(Column column, String content) {
        return null;
    }

    @Override
    public Project updateType(Column column, ColumnType type) {
        return null;
    }

    @Override
    public void deleteByContent(String content) {

    }

    @Override
    public void deleteByType(ColumnType type) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void deleteColumns() {

    }
}
