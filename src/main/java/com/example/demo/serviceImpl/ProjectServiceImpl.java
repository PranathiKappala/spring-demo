package com.example.demo.serviceImpl;

import com.example.demo.entites.Project;
import com.example.demo.repos.ProjectRepo;
import com.example.demo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepo projectRepo;


    @Override
    public Project saveProject(Project project) {
        System.out.println(project+"  " +"prooo");
        return projectRepo.save(project);
    }

    @Override
    public void deleteProject(Long id) {
        projectRepo.deleteById(id);
    }

    @Override
    public Optional<Project> getProjectById(Long id) {
        return projectRepo.findById(id);
    }

    @Override
    public Project updateProject(Project project) {
        if (projectRepo.existsById(project.getId())) {
            return projectRepo.save(project);
        } else {
            throw new IllegalArgumentException("Project with ID " + project.getId() + " does not exist.");
        }
    }



}

