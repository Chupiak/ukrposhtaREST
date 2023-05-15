package org.ukrposhtarest.model.programmer.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProgrammerRequestDto {
    private String firstName;
    private String lastName;
    private Long professionId;
}
