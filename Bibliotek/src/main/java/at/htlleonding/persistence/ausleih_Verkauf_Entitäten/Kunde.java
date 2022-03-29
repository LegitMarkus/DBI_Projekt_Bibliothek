package at.htlleonding.persistence.ausleih_Verkauf_Entitäten;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Kunde {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String kundennummer;

    @Column(nullable = false, length = 50)
    private String vorname;

    @Column(nullable = false, length = 50)
    private  String nachname;

    @OneToMany
    private Set<Reservierung> reservierungen = new HashSet<>();

    @OneToMany
    private Set<Ausleihung> ausleihungen = new HashSet<>();

    @OneToMany
    private Set<Rechnung> rechnungen = new HashSet<>();

}
