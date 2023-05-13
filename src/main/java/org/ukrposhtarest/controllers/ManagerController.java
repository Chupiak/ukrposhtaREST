package org.ukrposhtarest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.ukrposhtarest.model.manager.Manager;
import org.ukrposhtarest.model.manager.dto.ManagerDtoMapper;
import org.ukrposhtarest.model.manager.dto.ManagerRequestDto;
import org.ukrposhtarest.model.manager.dto.ManagerResponseDto;
import org.ukrposhtarest.service.manager.ManagerService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/managers")
public class ManagerController {

    @Autowired
    ManagerService managerService;


    @GetMapping("/")
    public List<ManagerResponseDto> getAllManagers() {
        List<Manager> managers = managerService.getAll();
        return managers.stream()
                   .map(ManagerDtoMapper::toResponseDto)
                   .collect(Collectors.toList());
    }

    @PostMapping
    public ManagerResponseDto create (@RequestBody ManagerRequestDto managerReqDto) {
        Manager manager = ManagerDtoMapper.fromRequestDto(managerReqDto);
        Manager createdManager = managerService.create(manager);
        return ManagerDtoMapper.toResponseDto(createdManager);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        managerService.delete(id);
    }

    @PutMapping("/{id}")
    public ManagerResponseDto update(@PathVariable("id") Long id, @RequestBody ManagerRequestDto managerReqDto) {
        Manager manager = ManagerDtoMapper.fromRequestDto(managerReqDto);
        Manager updatedManager = managerService.update(id, manager);
        return ManagerDtoMapper.toResponseDto(updatedManager);
    }

    @GetMapping("/{id}")
    public ManagerResponseDto getManagerById(@PathVariable("id") Long id) {
        Optional<Manager> optionalManager = managerService.getById(id);
        Manager manager = optionalManager.orElseThrow();
        return ManagerDtoMapper.toResponseDto(manager);
    }
}
