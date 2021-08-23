package com.itlize.korera.service;

import com.itlize.korera.model.Column;
import com.itlize.korera.model.ColumnType;
import com.itlize.korera.model.Project;
import com.itlize.korera.model.Resource;

import java.util.List;
import java.util.Optional;

public interface ColumnService {
    boolean columnContentExists(String content);
    boolean columnTypeExists(ColumnType type);
    boolean columnIdExists(Integer id);
    Column saveColumn(Column column);
    Column findById(Integer id);
    Column findByContent(String content);
    List<Column> findColumnsByType(ColumnType type);
    List<Column> getColumsByResource(String resourceName);
    List<Column> getColumns();
    Column updateContent(Column column, String content);
    Column updateType(Column column, ColumnType type);
    Column updateResource(String content, String resourceName);
    void deleteByContent(String content);
    void deleteByType(ColumnType type);
    void deleteById(Integer id);
    void deleteColumns();
}
