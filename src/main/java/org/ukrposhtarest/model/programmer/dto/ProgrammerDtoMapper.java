package org.ukrposhtarest.model.programmer.dto;

import org.ukrposhtarest.model.profession.Profession;
import org.ukrposhtarest.model.programmer.Programmer;

public class ProgrammerDtoMapper {
    public static Programmer toEntity(ProgrammerRequestDto requestDto) {
        Programmer programmer = new Programmer();
        programmer.setFirstName(requestDto.getFirstName());
        programmer.setLastName(requestDto.getLastName());

        Profession profession = new Profession();
        profession.setId(requestDto.getProfessionId());
        programmer.setProfession(profession);
        return programmer;
    }

    public static ProgrammerResponseDto toResponseDto(Programmer programmer) {
        ProgrammerResponseDto responseDto = new ProgrammerResponseDto();
        responseDto.setId(programmer.getId());
        responseDto.setFirstName(programmer.getFirstName());
        responseDto.setLastName(programmer.getLastName());

        responseDto.setProfessionId(programmer.getProfession().getId());
        return responseDto;
    }
}

