package org.ukrposhtarest.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.ukrposhtarest.model.programmer.Programmer;
import org.ukrposhtarest.model.programmer.dto.ProgrammerDtoMapper;
import org.ukrposhtarest.model.programmer.dto.ProgrammerRequestDto;
import org.ukrposhtarest.model.programmer.dto.ProgrammerResponseDto;
import org.ukrposhtarest.service.programmer.ProgrammerService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/programmers")
public class ProgrammerController {

    @Autowired
    ProgrammerService programmerService;

    @PostMapping
    public ProgrammerResponseDto create(@RequestBody ProgrammerRequestDto programmerRequestDto) {
        Programmer programmer = ProgrammerDtoMapper.toEntity(programmerRequestDto);
        Programmer savedProgrammer = programmerService.create(programmer);
        return ProgrammerDtoMapper.toResponseDto(savedProgrammer);
    }

    @GetMapping("/")
    public List<ProgrammerResponseDto> getAllProgrammers() {
        List<Programmer> programmers = programmerService.getAll();
        return programmers.stream()
                   .map(ProgrammerDtoMapper::toResponseDto)
                   .collect(Collectors.toList());
    }
}
