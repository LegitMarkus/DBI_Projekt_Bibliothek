package at.htlleonding.persistence.shop.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LendingKey implements Serializable {
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

    public Integer getMediaId() {
        return mediaId;
    }

    public void setMediaId(Integer mediaId) {
        this.mediaId = mediaId;
    }

    public Integer getCustommerId() {
        return custommerId;
    }

    public void setCustommerId(Integer custommerId) {
        this.custommerId = custommerId;
    }
}
