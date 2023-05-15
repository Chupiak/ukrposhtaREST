package org.ukrposhtarest.service.profession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.ukrposhtarest.model.profession.Profession;
import org.ukrposhtarest.repository.ProfessionRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProfessionServiceImpl implements ProfessionService{

    @Autowired
    ProfessionRepository professionRepository;


    @Override
    public Profession create(Profession profession) {
        try {
            return professionRepository.save(profession);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("You are trying to add a duplicate: " + profession.getLevelIt() + " " + profession.getTypeIt());
        }
    }

    @Override
    public void delete(Long id) {
        professionRepository.deleteById(id);
    }

    @Override
    public List<Profession> getAll() {
        return professionRepository.findAll();
    }

    @Override
    public Optional<Profession> getById(Long id) {
        return professionRepository.findById(id);
    }

    @Override
    public Profession update(Long id, Profession updateProfession) {
        Profession existingProfession = professionRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Profession with ID " + id + " not exist"));
        existingProfession.setTypeIt(updateProfession.getTypeIt());
        existingProfession.setLevelIt(updateProfession.getLevelIt());
        return professionRepository.save(existingProfession);
    }
}
