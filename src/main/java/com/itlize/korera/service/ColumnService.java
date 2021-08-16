package com.itlize.korera.service;

import com.itlize.korera.model.Column;
import com.itlize.korera.model.Project;

import java.util.List;
import java.util.Optional;

public interface ColumnService {
    Column saveColumn(Column column);
    Optional<Column> findByContent(String content);
    Optional<Column> findByType(String type);
    List<Column> getColumns();
    void deleteByContent(String content);
    void deleteByType(String type);
    void deleteColumns();
}
