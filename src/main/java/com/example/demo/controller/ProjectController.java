package com.example.demo.controller;

import com.example.demo.entites.Project;
import com.example.demo.service.ProjectService;
import lombok.Setter;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;
    @PostMapping
    public Project createProject(@RequestBody Project project){
        return projectService.saveProject(project);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable Long id){
        return projectService.getProjectById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteProject(@PathVariable Long id){
        return projectService.getProjectById(id)
                .map(project -> {
                    projectService.deleteProject(id);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable Long id, @RequestBody Project project) {
        return projectService.getProjectById(id)
                .map(existingProject -> {
                    // Update the fields of the existing project
                    existingProject.setProjectName(project.getProjectName());
//                    existingProject.setEmployee(project.getEmployee());

                    // Save the updated project
                    Project updatedProject = projectService.updateProject(existingProject);
                    return ResponseEntity.ok(updatedProject);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}