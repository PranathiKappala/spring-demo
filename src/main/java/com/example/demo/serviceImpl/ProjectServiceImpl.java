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
        System.out.println(id + " " + "-----====id");
        return projectRepo.findById(id);
    }

    @Override
    public Project updateProject(Project project) {
        return projectRepo.save(project);
    }



}

