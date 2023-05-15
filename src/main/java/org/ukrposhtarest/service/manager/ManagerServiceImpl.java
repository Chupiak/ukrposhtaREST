package org.ukrposhtarest.service.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ukrposhtarest.model.manager.Manager;
import org.ukrposhtarest.repository.ManagerRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ManagerServiceImpl implements ManagerService{

    @Autowired
    ManagerRepository managerRepository;


    @Override
    public Manager create(Manager manager) {
        return managerRepository.save(manager);
    }

    @Override
    public Manager update(Long id, Manager updatedManager) {
        Manager existingManager = managerRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Manager with ID " + id + " not exist"));
        existingManager.setFirstName(updatedManager.getFirstName());
        existingManager.setLastName(updatedManager.getLastName());
        return managerRepository.save(existingManager);
    }

    @Override
    public void delete(Long managerId) {
        managerRepository.deleteById(managerId);
    }

    @Override
    public List<Manager> getAll() {
        return managerRepository.findAll();
    }

    @Override
    public Optional<Manager> getById(Long managerId) {
        return managerRepository.findById(managerId);
    }
}
