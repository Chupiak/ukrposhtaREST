package org.ukrposhtarest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ukrposhtarest.model.programmer.Programmer;

public interface ProgrammerRepository extends JpaRepository<Programmer, Long> {
}
