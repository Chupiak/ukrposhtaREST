package org.ukrposhtarest.model.manager;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.ToString;
import org.ukrposhtarest.model.AbstractPerson;


@Entity
@Table(name = "managers")
@ToString
public class Manager extends AbstractPerson {
}
