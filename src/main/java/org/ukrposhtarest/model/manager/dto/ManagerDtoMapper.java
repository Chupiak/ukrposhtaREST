package org.ukrposhtarest.model.manager.dto;

import org.ukrposhtarest.model.manager.Manager;

public class ManagerDtoMapper {

    public static ManagerResponseDto toResponseDto(Manager manager) {
        ManagerResponseDto dto = new ManagerResponseDto();
        dto.setId(manager.getId());
        dto.setFirstName(manager.getFirstName());
        dto.setLastName(manager.getLastName());
        return dto;
    }

    public static Manager toEntity(ManagerRequestDto dto) {
        Manager manager = new Manager();
        manager.setFirstName(dto.getFirstName());
        manager.setLastName(dto.getLastName());
        return manager;
    }
}

