package org.ukrposhtarest.model.profession.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProfessionResponseDto {
    private Long id;
    private String typeIt;
    private String levelIt;
}
