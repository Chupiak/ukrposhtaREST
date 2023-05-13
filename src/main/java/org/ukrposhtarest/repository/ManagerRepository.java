package org.ukrposhtarest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ukrposhtarest.model.manager.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
}
