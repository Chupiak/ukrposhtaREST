package org.ukrposhtarest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ukrposhtarest.model.project.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
