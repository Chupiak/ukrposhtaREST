package org.ukrposhtarest.service.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ukrposhtarest.model.manager.Manager;
import org.ukrposhtarest.model.programmer.Programmer;
import org.ukrposhtarest.model.project.Project;
import org.ukrposhtarest.repository.ManagerRepository;
import org.ukrposhtarest.repository.ProgrammerRepository;
import org.ukrposhtarest.repository.ProjectRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService{

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    ManagerRepository managerRepository;

    @Autowired
    ProgrammerRepository programmerRepository;

    @Override
    public Project createProject() {
        return projectRepository.save(new Project());
    }

    @Override
    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    @Override
    public Optional<Project> getById(Long id) {
        return projectRepository.findById(id);
    }


    @Override
    public void delete(Long id) {
        Project project = projectRepository.findById(id).orElseThrow();
        project.getManagerList().clear();
        project.getProgrammerList().clear();
        projectRepository.deleteById(id);
    }

    @Override
    public void addManagerToProject(Long projectId, Long managerId) {
        Project project = projectRepository.findById(projectId).orElseThrow();
        Manager manager = managerRepository.findById(managerId).orElseThrow();
        project.getManagerList().add(manager);
        projectRepository.save(project);
    }

    @Override
    public void removeManagerFromProject(Long projectId, Long managerId) {
        Project project = projectRepository.findById(projectId).orElseThrow();
        Manager manager = managerRepository.findById(managerId).orElseThrow();
        project.getManagerList().remove(manager);
        projectRepository.save(project);
    }

    @Override
    public void addProgrammerToProject(Long projectId, Long programmerId) {
        Project project = projectRepository.findById(projectId).orElseThrow();
        Programmer programmer = programmerRepository.findById(programmerId).orElseThrow();
        project.getProgrammerList().add(programmer);
        projectRepository.save(project);
    }

    @Override
    public void removeProgrammerFromProject(Long projectId, Long programmerId) {
        Project project = projectRepository.findById(projectId).orElseThrow();
        Programmer programmer = programmerRepository.findById(programmerId).orElseThrow();
        project.getProgrammerList().remove(programmer);
        projectRepository.save(project);
    }
}
