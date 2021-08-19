package com.itlize.korera.service;

import com.itlize.korera.model.Column;
import com.itlize.korera.model.ColumnType;
import com.itlize.korera.model.Project;
import com.itlize.korera.model.Resource;

import java.util.List;
import java.util.Optional;

public interface ColumnService {
    boolean columnContentExists(String content);
    boolean columnIdExists(Integer id);
    Column saveColumn(Column column);
    Column findByContent(String content);
    Column findByType(ColumnType type);
    Column findById(Integer id);
    List<Column> getColumsByResource(Resource resource);
    List<Column> getColumns();
    Column updateContent(Column column, String content);
    Project updateType(Column column, ColumnType type);
    void deleteByContent(String content);
    void deleteByType(ColumnType type);
    void deleteById(Integer id);
    void deleteColumns();
}
