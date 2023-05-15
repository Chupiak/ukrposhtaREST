package org.ukrposhtarest.service.project;

import org.ukrposhtarest.model.project.Project;
import org.ukrposhtarest.service.GenericServiceForDeleteGetGetAll;

public interface ProjectService extends GenericServiceForDeleteGetGetAll<Project> {

    Project createProject();

    void addManagerToProject(Long projectId, Long managerId);

    void removeManagerFromProject(Long projectId, Long managerId);

    void addProgrammerToProject(Long projectId, Long programmerId);

    void removeProgrammerFromProject(Long projectId, Long programmerId);
}
