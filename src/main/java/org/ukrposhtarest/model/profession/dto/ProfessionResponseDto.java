package org.ukrposhtarest.model.profession.dto;

import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
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
