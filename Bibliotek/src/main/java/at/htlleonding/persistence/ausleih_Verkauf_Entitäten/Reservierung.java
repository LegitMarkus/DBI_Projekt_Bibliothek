package at.htlleonding.persistence.ausleih_Verkauf_Entitäten;

import at.htlleonding.persistence.SinglePhysicalMedium;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Reservierung {
    @ManyToOne
    @MapsId("medienId")
    private SinglePhysicalMedium medien;
    @MapsId("kundenId")
    @ManyToOne
    private Kunde kunde;

    private Date reserierungsDatum;

    @EmbeddedId
    ReservierungId id;

    public Reservierung(SinglePhysicalMedium medien, Kunde kunde, Date reserierungsDatum) {
        this.medien = medien;
        this.kunde = kunde;
        this.reserierungsDatum = reserierungsDatum;
    }
}
