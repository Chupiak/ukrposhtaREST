package org.ukrposhtarest.model.project.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.ukrposhtarest.model.manager.dto.ManagerResponseDto;
import org.ukrposhtarest.model.programmer.dto.ProgrammerResponseDto;

import java.util.List;

@Getter
@Setter
@ToString
public class ProjectResponseDto {
    private Long id;
    private List<ProgrammerResponseDto> programmers;
    private List<ManagerResponseDto> managers;
}
