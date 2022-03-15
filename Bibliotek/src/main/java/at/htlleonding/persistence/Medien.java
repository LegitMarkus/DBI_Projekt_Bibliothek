package at.htlleonding.persistence;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public class Medien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = false)
    private String titel;

    @Column
    private Date kaufdatum;

    @Column
    private Date veroeffentlichungsdatum;

    @ManyToOne
    private Verlag verlag;

    @Column
    private boolean uebersetzung;

    @ManyToOne
    private Sprache sprache;

    @ManyToMany
    private Set<Topic> topics;
}
