package org.ukrposhtarest.model.manager.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ManagerResponseDto {
    private Long id;
    private String firstName;
    private String lastName;
}
