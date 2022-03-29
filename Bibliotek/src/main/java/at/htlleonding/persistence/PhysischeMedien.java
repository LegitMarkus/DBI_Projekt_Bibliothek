package at.htlleonding.persistence;

import at.htlleonding.persistence.ausleih_Verkauf_Entitäten.Rechnung;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public class PhysischeMedien extends Medien{
    @Column(nullable = false)
    private Integer gesammtanzahl;
    @Column(nullable = false)
    private Integer verleih;
    @Column(nullable = false)
    private Integer freihandbereich;
    @Column(nullable = false)
    private boolean mitarbeiterverkauffreigabe;

    @ManyToMany
    private Set<Author> authors = new HashSet<>();

    @OneToMany
    private Set<Rechnung> rechnungen = new HashSet<>();
}
