package at.htlleonding.persistence.ausleih_Verkauf_Entitäten;

import at.htlleonding.persistence.Medien;
import at.htlleonding.persistence.PhysischeMedien;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

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
    private PhysischeMedien medien;
    @MapsId("kundenId")
    @ManyToOne
    private Kunde kunde;

    @Column(nullable = false)
    private Integer preis;
}
