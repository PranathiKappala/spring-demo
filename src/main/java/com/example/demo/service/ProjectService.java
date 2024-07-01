package com.example.demo.service;

import com.example.demo.entites.Project;

import java.util.Optional;

public interface ProjectService {
    Project saveProject(Project project);

    void deleteProject(Long id);

    Optional<Project> getProjectById(Long id);

    Project updateProject(Project project);
}
