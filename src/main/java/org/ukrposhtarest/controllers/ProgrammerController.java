package org.ukrposhtarest.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.ukrposhtarest.model.programmer.Programmer;
import org.ukrposhtarest.model.programmer.dto.ProgrammerDtoMapper;
import org.ukrposhtarest.model.programmer.dto.ProgrammerRequestDto;
import org.ukrposhtarest.model.programmer.dto.ProgrammerResponseDto;
import org.ukrposhtarest.service.programmer.ProgrammerService;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/programmers")
public class ProgrammerController {

    @Autowired
    ProgrammerService programmerService;

    @Autowired
    ProgrammerDtoMapper programmerDtoMapper;

    @PostMapping
    public ProgrammerResponseDto create(@RequestBody ProgrammerRequestDto programmerRequestDto) {
        Programmer programmer = programmerDtoMapper.programmerFromRequestDto(programmerRequestDto);
        programmerService.create(programmer);
        return programmerDtoMapper.toResponseDto(programmer);
    }

    @GetMapping("/")
    public List<ProgrammerResponseDto> getAllProgrammers() {
        List<Programmer> managers = programmerService.getAll();
        return managers.stream()
                   .map(programmerDtoMapper::toResponseDto)
                   .collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        programmerService.delete(id);
    }

    @GetMapping("/{id}")
    public ProgrammerResponseDto getProgrammerById(@PathVariable("id") Long id) {
        Programmer programmer = programmerService.getById(id).orElseThrow(() -> new NoSuchElementException("Programmer with ID " + id + " not exist"));
        return programmerDtoMapper.toResponseDto(programmer);
    }

    @PutMapping("/{id}")
    public ProgrammerResponseDto update(@PathVariable("id") Long id, @RequestBody ProgrammerRequestDto managerReqDto) {
        Programmer programmer = programmerDtoMapper.programmerFromRequestDto(managerReqDto);
        Programmer updatedProgrammer = programmerService.update(id, programmer);
        return programmerDtoMapper.toResponseDto(updatedProgrammer);
    }
}
