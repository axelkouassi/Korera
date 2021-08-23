package com.itlize.korera.repository;

import com.itlize.korera.model.Column;
import com.itlize.korera.model.ColumnType;
import com.itlize.korera.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ColumnRepository extends JpaRepository<Column,Integer> {
    boolean existsByContent(String content);
    boolean existsByColumnType(ColumnType type);
    Optional<Column> findByContent(String content);
    Optional<Column> findByColumnType(ColumnType type);
    List<Column> findAllByColumnType(ColumnType type);
    List<Column> findAllByResource_ResourceName(String resourceName);
    void  deleteByContent(String content);
    void deleteByColumnType(ColumnType type);
}
