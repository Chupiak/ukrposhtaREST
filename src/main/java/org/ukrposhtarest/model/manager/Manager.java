package org.ukrposhtarest.model.manager;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.ukrposhtarest.model.AbstractPerson;


@Entity
@Table(name = "managers")
public class Manager extends AbstractPerson {
}
