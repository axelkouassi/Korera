package com.itlize.korera.repository;

import com.itlize.korera.model.Column;
import com.itlize.korera.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ColumnRepository extends JpaRepository<Column,Integer> {
    Optional<Column> findByContent(String content);
    boolean existsByContent(String content);
    void deleteByContent(String content);
}
