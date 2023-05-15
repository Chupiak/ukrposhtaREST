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
    public Project projectFromRequestDto (ProjectRequestDto requestDto) {

        List<Programmer> programmerList = requestDto
                                           .getProgrammerIds().stream()
                                           .map(id -> {
                                               Programmer programmer = new Programmer();
                                               programmer.setId(id);
                                               return programmer;
                                           })
                                           .collect(Collectors.toList());

        List<Manager> managerList = requestDto.getManagerIds().stream()
                                     .map(id -> {
                                         Manager manager = new Manager();
                                         manager.setId(id);
                                         return manager;
                                     })
                                     .collect(Collectors.toList());

        Project project = new Project();
        project.setManagerList(managerList);
        project.setProgrammerList(programmerList);
        return project;
    }

    public ProjectResponseDto mapToResponseDto(Project project) {

        List<ProgrammerResponseDto> programmerResponseDtoList = project.getProgrammerList().stream()
                                                                 .map(programmer -> {
                                                                     ProgrammerResponseDto programmerResponseDto = new ProgrammerResponseDto();
                                                                     programmerResponseDto.setId(programmer.getId());
                                                                     programmerResponseDto.setFirstName(programmer.getFirstName());
                                                                     programmerResponseDto.setLastName(programmer.getLastName());
                                                                     programmerResponseDto.setProfession(programmer.getProfession());
                                                                     return programmerResponseDto;
                                                                 })
                                                                 .collect(Collectors.toList());

        List<ManagerResponseDto> managerResponseDtoList = project.getManagerList().stream()
                                                           .map(manager -> {
                                                               ManagerResponseDto managerResponseDto = new ManagerResponseDto();
                                                               managerResponseDto.setId(manager.getId());
                                                               managerResponseDto.setFirstName(manager.getFirstName());
                                                               managerResponseDto.setLastName(manager.getLastName());
                                                               return managerResponseDto;
                                                           })
                                                           .collect(Collectors.toList());

        ProjectResponseDto responseDto = new ProjectResponseDto();
        responseDto.setId(project.getId());
        responseDto.setProgrammers(programmerResponseDtoList);
        responseDto.setManagers(managerResponseDtoList);
        return responseDto;
    }
}
