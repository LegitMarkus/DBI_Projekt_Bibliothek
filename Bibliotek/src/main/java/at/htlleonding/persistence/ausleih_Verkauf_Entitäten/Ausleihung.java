package at.htlleonding.persistence.ausleih_Verkauf_Entitäten;

import at.htlleonding.persistence.SinglePhysicalMedium;
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
public class Ausleihung {
    @EmbeddedId
    AusleihId id;

    @ManyToOne
    @MapsId("medienId")
    private SinglePhysicalMedium medien;
    @MapsId("kundenId")
    @ManyToOne
    private Kunde kunde;

    @Column(nullable = false)
    private Date ausleihdatum;

    @Column(nullable = false)
    private Date rückgabedatum;

    @Column
    private Integer verlängerung = 0;

    public Ausleihung(SinglePhysicalMedium medien, Kunde kunde, Date ausleihdatum, Date rückgabedatum) {
        this.medien = medien;
        this.kunde = kunde;
        this.ausleihdatum = ausleihdatum;
        this.rückgabedatum = rückgabedatum;
    }
}
