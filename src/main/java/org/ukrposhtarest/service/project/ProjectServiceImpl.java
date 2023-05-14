package org.ukrposhtarest.service.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ukrposhtarest.dao.ProjectDao;
import org.ukrposhtarest.model.project.Project;
import org.ukrposhtarest.repository.ProjectRepository;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService{

    @Autowired
    ProjectRepository projectRepository;

    @Override
    public Project create() {
        Project project = new Project();
        return projectRepository.save(project);
    }

    @Override
    public List<Project> getAll() {
        return projectRepository.findAll();
    }
}
