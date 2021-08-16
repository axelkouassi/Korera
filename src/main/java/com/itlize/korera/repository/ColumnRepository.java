package com.itlize.korera.repository;

import com.itlize.korera.model.Column;
import com.itlize.korera.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ColumnRepository extends JpaRepository<Column,Integer> {
    Optional<Column> findByContent(String content);
    void deleteByContent(String content);
}
