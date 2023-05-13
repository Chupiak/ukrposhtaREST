package org.ukrposhtarest.model.profession.dto;


import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProfessionRequestDto {
    private String typeIt;
    private String levelIt;
}
