package com.itlize.korera.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.persistence.Column;
import java.time.LocalDateTime;

@Entity
@Table(name="project_resource")
public class ProjectResource {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="project_resource_id", nullable = false, unique = true, updatable = false)
    private Integer projectResourceId;

    @ManyToOne(cascade= {CascadeType.DETACH}, targetEntity = Project.class)
    @JoinColumn(name="project_id")
    private Project project;

    @ManyToOne(cascade= {CascadeType.DETACH}, targetEntity = Resource.class)
    @JoinColumn(name="resource_id")
    private Resource resource;

    @CreatedDate
   @Column(name="time_created")
    private LocalDateTime timeCreated;

    @LastModifiedDate
    @Column(name="time_updated")
    private LocalDateTime timeUpdated;

    public Integer getProjectResourceId() {
        return projectResourceId;
    }

    public void setProjectResourceId(Integer projectResourceId) {
        this.projectResourceId = projectResourceId;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
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


}
