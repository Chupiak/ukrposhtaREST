package org.ukrposhtarest.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.ukrposhtarest.model.profession.Profession;
import org.ukrposhtarest.model.profession.dto.ProfessionDtoMapper;
import org.ukrposhtarest.model.profession.dto.ProfessionRequestDto;
import org.ukrposhtarest.model.profession.dto.ProfessionResponseDto;
import org.ukrposhtarest.service.profession.ProfessionService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/professions")
public class ProfessionController {

    @Autowired
    ProfessionService professionService;

    @PostMapping
    public ProfessionResponseDto create(@RequestBody ProfessionRequestDto professionRequestDto) {
        Profession profession = ProfessionDtoMapper.professionFromRequestDto(professionRequestDto);
        professionService.create(profession);
        return ProfessionDtoMapper.professionToResponseDto(profession);
    }

    @GetMapping("/")
    public List<ProfessionResponseDto> getAllProfession() {
        List<Profession> professions = professionService.getAll();
        return professions.stream()
                   .map(ProfessionDtoMapper::professionToResponseDto)
                   .collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        professionService.delete(id);
    }

    @GetMapping("/{id}")
    public ProfessionResponseDto getProfessionById(@PathVariable("id") Long id) {
        Profession profession = professionService.getById(id).orElseThrow(() -> new NoSuchElementException("Profession with ID " + id + " not exist"));
        return ProfessionDtoMapper.professionToResponseDto(profession);
    }

    @PutMapping("/{id}")
    public ProfessionResponseDto update(@PathVariable("id") Long id, @RequestBody ProfessionRequestDto professionRequestDto) {
        Profession profession = ProfessionDtoMapper.professionFromRequestDto(professionRequestDto);
        return ProfessionDtoMapper.professionToResponseDto(professionService.update(id, profession));
    }
}
