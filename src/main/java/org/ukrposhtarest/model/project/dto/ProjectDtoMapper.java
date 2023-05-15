package org.ukrposhtarest.model.project.dto;

import org.springframework.stereotype.Service;
import org.ukrposhtarest.model.manager.Manager;
import org.ukrposhtarest.model.manager.dto.ManagerResponseDto;
import org.ukrposhtarest.model.programmer.Programmer;
import org.ukrposhtarest.model.programmer.dto.ProgrammerResponseDto;
import org.ukrposhtarest.model.project.Project;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectDtoMapper {

    public Project mapToEntity(ProjectRequestDto requestDto) {
        Project project = new Project();

        List<Programmer> programmers = requestDto.getProgrammerIds().stream()
                                           .map(id -> {
                                               Programmer programmer = new Programmer();
                                               programmer.setId(id);
                                               return programmer;
                                           })
                                           .collect(Collectors.toList());
        project.setProgrammerList(programmers);

        List<Manager> managers = requestDto.getManagerIds().stream()
                                     .map(id -> {
                                         Manager manager = new Manager();
                                         manager.setId(id);
                                         return manager;
                                     })
                                     .collect(Collectors.toList());
        project.setManagerList(managers);

        return project;
    }

    public ProjectResponseDto mapToResponseDto(Project project) {
        ProjectResponseDto responseDto = new ProjectResponseDto();
        responseDto.setId(project.getId());

        List<ProgrammerResponseDto> programmerResponseDtos = project.getProgrammerList().stream()
                                                                 .map(programmer -> {
                                                                     ProgrammerResponseDto programmerResponseDto = new ProgrammerResponseDto();
                                                                     programmerResponseDto.setId(programmer.getId());
                                                                     programmerResponseDto.setFirstName(programmer.getFirstName());
                                                                     programmerResponseDto.setLastName(programmer.getLastName());
                                                                     programmerResponseDto.setProfession(programmer.getProfession());
                                                                     return programmerResponseDto;
                                                                 })
                                                                 .collect(Collectors.toList());
        responseDto.setProgrammers(programmerResponseDtos);

        List<ManagerResponseDto> managerResponseDtos = project.getManagerList().stream()
                                                           .map(manager -> {
                                                               ManagerResponseDto managerResponseDto = new ManagerResponseDto();
                                                               managerResponseDto.setId(manager.getId());
                                                               managerResponseDto.setFirstName(manager.getFirstName());
                                                               managerResponseDto.setLastName(manager.getLastName());
                                                               return managerResponseDto;
                                                           })
                                                           .collect(Collectors.toList());
        responseDto.setManagers(managerResponseDtos);

        return responseDto;
    }
}
