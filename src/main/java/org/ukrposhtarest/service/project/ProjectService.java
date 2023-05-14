package org.ukrposhtarest.service.project;

import org.ukrposhtarest.model.project.Project;

import java.util.List;

public interface ProjectService {
    Project create();
    List<Project> getAll();
}
