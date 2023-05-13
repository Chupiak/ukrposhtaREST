package org.ukrposhtarest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ukrposhtarest.model.manager.Manager;
import org.ukrposhtarest.model.profession.Profession;

public interface ProfessionRepository extends JpaRepository<Profession, Long> {
}
