package com.itlize.korera.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="columns")
public class Column {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @javax.persistence.Column(name="column_id", nullable = false, unique = true, updatable = false)
    private Integer columnId;

    @javax.persistence.Column(name="content", nullable = false, unique = true)
    private String content;

    @Enumerated(EnumType.STRING)
    @javax.persistence.Column(name="column_type")
    private ColumnType columnType = ColumnType.TEXT;

    @ManyToOne(cascade= {CascadeType.MERGE})
    @JoinColumn(name="resource_id")
    private Resource resource;

    @CreatedDate
    @javax.persistence.Column(name="time_created")
    private LocalDateTime timeCreated;

    @LastModifiedDate
    @javax.persistence.Column(name="time_updated")
    private LocalDateTime timeUpdated;

    public Integer getColumnId() {
        return columnId;
    }

    public void setColumnId(Integer columnId) {
        this.columnId = columnId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ColumnType getColumnType() {
        return columnType;
    }

    public void setColumnType(ColumnType columnType) {
        this.columnType = columnType;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(LocalDateTime timeCreated) {
        this.timeCreated = timeCreated;
    }

    public LocalDateTime getTimeUpdated() {
        return timeUpdated;
    }

    public void setTimeUpdated(LocalDateTime timeUpdated) {
        this.timeUpdated = timeUpdated;
    }

   /* @Override
    public String toString() {
        return "Column{" +
                "columnId=" + columnId +
                ", content='" + content + '\'' +
                ", columnType=" + columnType +
                ", resource=" + resource +
                ", timeCreated=" + timeCreated +
                ", timeUpdated=" + timeUpdated +
                '}';
    }*/
}
