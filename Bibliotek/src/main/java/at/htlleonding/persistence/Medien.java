package at.htlleonding.persistence;

import at.htlleonding.persistence.ausleih_Verkauf_Entitäten.Ausleihung;
import at.htlleonding.persistence.ausleih_Verkauf_Entitäten.Rechnung;
import at.htlleonding.persistence.ausleih_Verkauf_Entitäten.Reservierung;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
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
    private Date veroeffentlichungsdatum;

    @ManyToOne
    private Verlag verlag;

    @Column
    private boolean uebersetzung;

    @ManyToOne
    private Sprache sprache;

    @ManyToMany
    private Set<Topic> topics = new HashSet<>();;

    @ManyToOne
    private Genre genre;

    @ManyToMany
    @JoinColumn
    private Set<Author> authors = new HashSet<Author>();

}
