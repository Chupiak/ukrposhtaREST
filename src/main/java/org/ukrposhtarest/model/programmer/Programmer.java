package org.ukrposhtarest.model.programmer;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.ukrposhtarest.model.AbstractPerson;
import org.ukrposhtarest.model.profession.Profession;


@Entity
@Table(name = "programmers")
@Getter
@Setter
@ToString
public class Programmer extends AbstractPerson {
    @ManyToOne
    @JoinColumn(name = "profession_id")
    private Profession profession;
}
