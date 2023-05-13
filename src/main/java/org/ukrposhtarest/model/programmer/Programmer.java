package org.ukrposhtarest.model.programmer;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.ukrposhtarest.model.AbstractPerson;


@Entity
@Table(name = "programmers")
@Getter
@Setter
@ToString
public class Programmer extends AbstractPerson {

    @ManyToOne
    @JoinColumn(name = "programmer_id")
    private Programmer programmer;
}
