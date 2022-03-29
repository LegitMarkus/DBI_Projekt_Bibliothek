package at.htlleonding.persistence.ausleih_Verkauf_Entitäten;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class AusleihId implements Serializable {
    @Column
    Integer medienId;
    @Column
    Integer kundenId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservierungId that = (ReservierungId) o;
        return Objects.equals(medienId, that.medienId) && Objects.equals(kundenId, that.kundenId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(medienId, kundenId);
    }

}
