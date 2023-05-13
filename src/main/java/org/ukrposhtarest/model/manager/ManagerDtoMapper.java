package org.ukrposhtarest.model.manager;

public class ManagerDtoMapper {

    public static ManagerResponseDto toManagerResponseDto(Manager manager) {
        ManagerResponseDto dto = new ManagerResponseDto();
        dto.setId(manager.getId());
        dto.setFirstName(manager.getFirstName());
        dto.setLastName(manager.getLastName());
        return dto;
    }

    public static Manager fromManagerRequestDto(ManagerRequestDto dto) {
        Manager manager = new Manager();
        manager.setFirstName(dto.getFirstName());
        manager.setLastName(dto.getLastName());
        return manager;
    }
}

