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
public class BorrowingKey implements Serializable {
    @Column
    Integer mediaId;
    @Column
    Integer custommerId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservationKey that = (ReservationKey) o;
        return Objects.equals(mediaId, that.mediaId) && Objects.equals(custommerId, that.customerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mediaId, custommerId);
    }

}
