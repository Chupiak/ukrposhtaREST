package org.ukrposhtarest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.ukrposhtarest.model.project.Project;
import org.ukrposhtarest.model.project.dto.ProjectDtoMapper;
import org.ukrposhtarest.model.project.dto.ProjectResponseDto;
import org.ukrposhtarest.service.manager.ManagerService;
import org.ukrposhtarest.service.programmer.ProgrammerService;
import org.ukrposhtarest.service.project.ProjectService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @Autowired
    ManagerService managerService;

    @Autowired
    ProgrammerService programmerService;

    @Autowired
    ProjectDtoMapper projectDtoMapper;

    @PostMapping
    public ProjectResponseDto create() {
        return projectDtoMapper.mapToResponseDto(projectService.createProject());
    }

    @GetMapping("/")
    public List<ProjectResponseDto> getAllProjects() {
        List<Project> projects = projectService.getAll();
        return projects.stream()
                   .map(projectDtoMapper::mapToResponseDto)
                   .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ProjectResponseDto getProjectById(@PathVariable("id") Long id) {
        Project project = projectService.getById(id).orElseThrow();
        return projectDtoMapper.mapToResponseDto(project);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        projectService.delete(id);
    }

    @PostMapping("/{projectId}/add/manager/{managerId}")
    public void addManagerToProject(@PathVariable Long projectId, @PathVariable Long managerId) {
        projectService.addManagerToProject(projectId, managerId);
    }

    @PostMapping("/{projectId}/remove/manager/{managerId}")
    public void removeManagerFromProject(@PathVariable Long projectId, @PathVariable Long managerId) {
        projectService.removeManagerFromProject(projectId, managerId);
    }

    @PostMapping("/{projectId}/add/programmer/{programmerId}")
    public void addProgrammerToProject(@PathVariable Long projectId, @PathVariable Long programmerId) {
        projectService.addProgrammerToProject(projectId, programmerId);
    }

    @PostMapping("/{projectId}/remove/programmer/{programmerId}")
    public void removeProgrammerFromProject(@PathVariable Long projectId, @PathVariable Long programmerId) {
        projectService.removeProgrammerFromProject(projectId, programmerId);
    }
}
