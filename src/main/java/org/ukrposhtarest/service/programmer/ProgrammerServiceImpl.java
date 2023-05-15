package org.ukrposhtarest.service.programmer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ukrposhtarest.model.programmer.Programmer;
import org.ukrposhtarest.repository.ProgrammerRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProgrammerServiceImpl implements ProgrammerService{

    @Autowired
    ProgrammerRepository programmerRepository;

    @Override
    public Programmer create(Programmer programmer) {
        return programmerRepository.save(programmer);
    }

    @Override
    public void delete(Long id) {
        programmerRepository.deleteById(id);
    }

    @Override
    public List<Programmer> getAll() {
        return programmerRepository.findAll();
    }

    @Override
    public Optional<Programmer> getById(Long id) {
        return programmerRepository.findById(id);
    }

    @Override
    public Programmer update(Long id, Programmer updateProgrammer) {
        Programmer existingProgrammer = programmerRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Programmer with ID " + id + " not exist"));
        existingProgrammer.setFirstName(updateProgrammer.getFirstName());
        existingProgrammer.setLastName(updateProgrammer.getLastName());
        existingProgrammer.setProfession(updateProgrammer.getProfession());
        return programmerRepository.save(existingProgrammer);
    }
}
