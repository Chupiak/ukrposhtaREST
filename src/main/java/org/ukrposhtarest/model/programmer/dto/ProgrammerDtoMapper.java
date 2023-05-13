package org.ukrposhtarest.model.programmer.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ukrposhtarest.model.profession.Profession;
import org.ukrposhtarest.model.programmer.Programmer;
import org.ukrposhtarest.service.profession.ProfessionService;

@Service
public class ProgrammerDtoMapper {
    @Autowired
    ProfessionService professionService;

    public Programmer toEntity(ProgrammerRequestDto dto) {
        Profession profession = professionService.getById(dto.getProfessionId()).orElseThrow();

        Programmer programmer = new Programmer();
        programmer.setFirstName(dto.getFirstName());
        programmer.setLastName(dto.getLastName());
        programmer.setProfession(profession);

        return programmer;
    }

    public ProgrammerResponseDto toResponseDto(Programmer programmer) {
        ProgrammerResponseDto dto = new ProgrammerResponseDto();
        dto.setId(programmer.getId());
        dto.setFirstName(programmer.getFirstName());
        dto.setLastName(programmer.getLastName());
        dto.setProfession(programmer.getProfession());

        return dto;
    }
}

