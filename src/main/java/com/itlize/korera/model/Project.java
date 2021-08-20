package com.itlize.korera.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="project_id", nullable = false, unique = true, updatable = false)
    private Integer projectId;

    @Column(name="project_name", nullable = false, unique = true)
    private  String projectName;

    @ManyToOne(cascade= {CascadeType.MERGE})
    @JoinColumn(name="user_id")
    private User user;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="project", cascade= CascadeType.ALL)
    private List<ProjectResource> projectResource;

    @CreatedDate
    @Column(name="time_created")
    private LocalDateTime timeCreated;

    @LastModifiedDate
    @Column(name="time_updated")
    private LocalDateTime timeUpdated;

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<ProjectResource> getProjectResource() {
        return projectResource;
    }

    public void setProjectResource(List<ProjectResource> projectResource) {
        this.projectResource = projectResource;
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
        return "Project{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", user=" + user +
                ", projectResource=" + projectResource +
                ", timeCreated=" + timeCreated +
                ", timeUpdated=" + timeUpdated +
                '}';
    }
}
