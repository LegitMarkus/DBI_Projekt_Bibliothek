package at.htlleonding.persistence;

import at.htlleonding.persistence.ausleih_Verkauf_Entitäten.Ausleihung;
import at.htlleonding.persistence.ausleih_Verkauf_Entitäten.Rechnung;
import at.htlleonding.persistence.ausleih_Verkauf_Entitäten.Reservierung;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class SinglePhysicalMedium
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private PhysischeMedien physischeMedien;

    @Column
    private Date kaufdatum;

    @Column
    private Boolean verkauf = false;

    @OneToMany
    private Set<Rechnung> rechnungen = new HashSet<>();

    @OneToMany
    private Set<Reservierung> reservierungen = new HashSet<>();

    @OneToMany
    private Set<Ausleihung> ausleihungen = new HashSet<>();
}
