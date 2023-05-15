package org.ukrposhtarest.service.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.ukrposhtarest.model.manager.Manager;
import org.ukrposhtarest.model.programmer.Programmer;
import org.ukrposhtarest.model.project.Project;
import org.ukrposhtarest.repository.ManagerRepository;
import org.ukrposhtarest.repository.ProgrammerRepository;
import org.ukrposhtarest.repository.ProjectRepository;

import java.util.List;
import java.util.NoSuchElementException;
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
        projectRepository.deleteById(id);
    }

    @Override
    public void addManagerToProject(Long projectId, Long managerId) {
        Project project = projectRepository
                              .findById(projectId)
                              .orElseThrow(() -> new NoSuchElementException("Project with ID " + projectId + " not exist"));
        Manager manager = managerRepository
                              .findById(managerId)
                              .orElseThrow(() -> new NoSuchElementException("Manager with ID " + managerId + " not exist"));
        project.getManagerList().add(manager);
        try {
            projectRepository.save(project);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("You are trying to add a duplicate manager to the project");
        }
    }

    @Override
    public void removeManagerFromProject(Long projectId, Long managerId) {
        Project project = projectRepository
                              .findById(projectId)
                              .orElseThrow(() -> new NoSuchElementException("Project with ID " + projectId + " not exist"));
        Manager manager = managerRepository
                              .findById(managerId)
                              .orElseThrow(() -> new NoSuchElementException("Manager with ID " + managerId + " not exist"));
        project.getManagerList().remove(manager);
        projectRepository.save(project);
    }

    @Override
    public void addProgrammerToProject(Long projectId, Long programmerId) {
        Project project = projectRepository
                              .findById(projectId)
                              .orElseThrow(() -> new NoSuchElementException("Project with ID " + projectId + " not exist"));
        Programmer programmer = programmerRepository.findById(programmerId).orElseThrow(() -> new NoSuchElementException("Programmer with ID " + programmerId + " not exist"));
        project.getProgrammerList().add(programmer);
        try{
            projectRepository.save(project);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("You are trying to add a duplicate programmer to the project");
        }
    }

    @Override
    public void removeProgrammerFromProject(Long projectId, Long programmerId) {
        Project project = projectRepository
                              .findById(projectId)
                              .orElseThrow(() -> new NoSuchElementException("Project with ID " + projectId + " not exist"));
        Programmer programmer = programmerRepository
                                    .findById(programmerId)
                                    .orElseThrow(() -> new NoSuchElementException("Programmer with ID " + programmerId + " not exist"));
        project.getProgrammerList().remove(programmer);
        projectRepository.save(project);
    }
}
