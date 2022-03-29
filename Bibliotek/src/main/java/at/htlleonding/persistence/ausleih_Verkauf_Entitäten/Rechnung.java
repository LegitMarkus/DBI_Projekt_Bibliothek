package at.htlleonding.persistence.ausleih_Verkauf_Entitäten;

import at.htlleonding.persistence.SinglePhysicalMedium;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Rechnung {
    @EmbeddedId
    RechnungId id;

    @ManyToOne
    @MapsId("medienId")
    private SinglePhysicalMedium medien;
    @MapsId("kundenId")
    @ManyToOne
    private Kunde kunde;

    @Column(nullable = false)
    private Integer preis;

    public Rechnung(SinglePhysicalMedium medien, Kunde kunde, Integer preis) {
        this.medien = medien;
        this.kunde = kunde;
        this.preis = preis;
    }
}
