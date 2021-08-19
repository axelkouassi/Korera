package com.itlize.korera.service.serviceimpl;

import com.itlize.korera.model.Column;
import com.itlize.korera.model.ColumnType;
import com.itlize.korera.model.Project;
import com.itlize.korera.model.Resource;
import com.itlize.korera.service.ColumnService;

import java.util.List;

public class ColumnServiceImpl implements ColumnService {
    @Override
    public boolean columnContentExists(String content) {
        return false;
    }

    @Override
    public boolean columnIdExists(Integer id) {
        return false;
    }

    @Override
    public Column saveColumn(Column column) {
        return null;
    }

    @Override
    public Column findByContent(String content) {
        return null;
    }

    @Override
    public Column findByType(ColumnType type) {
        return null;
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
