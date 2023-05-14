package org.ukrposhtarest.model.project;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.ukrposhtarest.model.manager.Manager;
import org.ukrposhtarest.model.programmer.Programmer;

import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinTable(name = "projects_programmer_list",
        joinColumns = @JoinColumn(name = "project_id"),
        inverseJoinColumns = @JoinColumn(name = "programmer_id"),
        uniqueConstraints = @UniqueConstraint(columnNames = {"project_id", "programmer_id"}))
    private List<Programmer> programmerList;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinTable(name = "projects_manager_list",
        joinColumns = @JoinColumn(name = "project_id"),
        inverseJoinColumns = @JoinColumn(name = "manager_id"),
        uniqueConstraints = @UniqueConstraint(columnNames = {"project_id", "manager_id"}))
    private List<Manager> managerList;
}
