package org.ukrposhtarest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.ukrposhtarest.model.manager.Manager;
import org.ukrposhtarest.model.manager.dto.ManagerDtoMapper;
import org.ukrposhtarest.model.manager.dto.ManagerRequestDto;
import org.ukrposhtarest.model.manager.dto.ManagerResponseDto;
import org.ukrposhtarest.model.programmer.Programmer;
import org.ukrposhtarest.model.programmer.dto.ProgrammerResponseDto;
import org.ukrposhtarest.model.project.Project;
import org.ukrposhtarest.model.project.dto.ProjectDtoMapper;
import org.ukrposhtarest.model.project.dto.ProjectRequestDto;
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
        Project project = projectService.create();
        project.setManagerList(List.of());
        project.setProgrammerList(List.of());
        return projectDtoMapper.mapToResponseDto(project);
    }

    @GetMapping("/")
    public List<ProjectResponseDto> getAllProjects() {
        List<Project> projects = projectService.getAll();
        return projects.stream()
                   .map(projectDtoMapper::mapToResponseDto)
                   .collect(Collectors.toList());
    }
}
