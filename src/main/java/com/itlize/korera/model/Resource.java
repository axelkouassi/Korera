package com.itlize.korera.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="resource")
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="resource_id", nullable = false, unique = true, updatable = false)
    private Integer resourceId;

    @Column(name="resource_name", nullable = false, unique = true)
    private  String resourceName;

    @Column(name="resource_code", nullable = false, unique = true)
    private  String resourceCode;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="resource", cascade= CascadeType.ALL)
    private List<com.itlize.korera.model.Column> columns;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="resource", cascade= CascadeType.ALL)
    private List<ProjectResource> projectResources;

    @CreatedDate
    @Column(name="time_created")
    private LocalDateTime timeCreated;

    @LastModifiedDate
    @Column(name="time_updated")
    private LocalDateTime timeUpdated;

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceCode() {
        return resourceCode;
    }

    public void setResourceCode(String resourceCode) {
        this.resourceCode = resourceCode;
    }

    public List<com.itlize.korera.model.Column> getColumns() {
        return columns;
    }

    public void setColumns(List<com.itlize.korera.model.Column> columns) {
        this.columns = columns;
    }

    public List<ProjectResource> getProjectResources() {
        return projectResources;
    }

    public void setProjectResources(List<ProjectResource> projectResources) {
        this.projectResources = projectResources;
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

    @Override
    public String toString() {
        return "Resource{" +
                "resourceId=" + resourceId +
                ", resourceName='" + resourceName + '\'' +
                ", resourceCode='" + resourceCode + '\'' +
                ", columns=" + columns +
                ", projectResources=" + projectResources +
                ", timeCreated=" + timeCreated +
                ", timeUpdated=" + timeUpdated +
                '}';
    }
}
