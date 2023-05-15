package org.ukrposhtarest.model.profession.dto;

import org.ukrposhtarest.model.profession.Profession;

public class ProfessionDtoMapper {

    public static Profession professionFromRequestDto(ProfessionRequestDto requestDto) {
        Profession profession = new Profession();
        profession.setTypeIt(requestDto.getTypeIt());
        profession.setLevelIt(requestDto.getLevelIt());
        return profession;
    }

    public static ProfessionResponseDto professionToResponseDto(Profession profession) {
        ProfessionResponseDto responseDto = new ProfessionResponseDto();
        responseDto.setId(profession.getId());
        responseDto.setTypeIt(profession.getTypeIt());
        responseDto.setLevelIt(profession.getLevelIt());
        return responseDto;
    }
}
