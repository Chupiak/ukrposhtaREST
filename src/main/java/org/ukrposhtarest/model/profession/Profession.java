package org.ukrposhtarest.model.profession;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "profession", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"type_it", "level_it"})
})
@EqualsAndHashCode
@NoArgsConstructor
public class Profession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type_it")
    private String typeIt;

    @Column(name = "level_it")
    private String levelIt;
}
