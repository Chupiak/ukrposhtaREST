package org.ukrposhtarest.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.ukrposhtarest.model.profession.Profession;
import org.ukrposhtarest.model.profession.dto.ProfessionDtoMapper;
import org.ukrposhtarest.model.profession.dto.ProfessionRequestDto;
import org.ukrposhtarest.model.profession.dto.ProfessionResponseDto;
import org.ukrposhtarest.service.profession.ProfessionService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/professions")
public class ProfessionController {

    @Autowired
    ProfessionService professionService;

    @PostMapping
    public ProfessionResponseDto create(@RequestBody ProfessionRequestDto professionRequestDto) {
        Profession profession = ProfessionDtoMapper.fromRequestDto(professionRequestDto);
        Profession createdProfession = professionService.create(profession);
        return ProfessionDtoMapper.toResponseDto(createdProfession);
    }

    @GetMapping("/")
    public List<ProfessionResponseDto> getAllProfession() {
        List<Profession> professions = professionService.getAll();
        return professions.stream()
                   .map(ProfessionDtoMapper::toResponseDto)
                   .collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        professionService.delete(id);
    }

    @GetMapping("/{id}")
    public ProfessionResponseDto getProfessionById(@PathVariable("id") Long id) {
        Optional<Profession> optionalProfession = professionService.getById(id);
        Profession profession = optionalProfession.orElseThrow();
        return ProfessionDtoMapper.toResponseDto(profession);
    }

    @PutMapping("/{id}")
    public ProfessionResponseDto update(@PathVariable("id") Long id, @RequestBody ProfessionRequestDto professionRequestDto) {
        Profession profession = ProfessionDtoMapper.fromRequestDto(professionRequestDto);
        Profession updatedProfession = professionService.update(id, profession);
        return ProfessionDtoMapper.toResponseDto(updatedProfession);
    }
}
