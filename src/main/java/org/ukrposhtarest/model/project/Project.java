package org.ukrposhtarest.model.project;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.ukrposhtarest.model.manager.Manager;
import org.ukrposhtarest.model.programmer.Programmer;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "projects")
@EqualsAndHashCode
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<Programmer> programmerList = new ArrayList<>();

    @OneToMany
    private List<Manager> managerList = new ArrayList<>();
}
