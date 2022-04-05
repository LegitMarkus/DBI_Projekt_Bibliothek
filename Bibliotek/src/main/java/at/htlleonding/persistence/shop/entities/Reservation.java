package at.htlleonding.persistence.shop.entities;

import at.htlleonding.persistence.SinglePhysicalMedia;
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
public class Reservation {
    @ManyToOne
    @MapsId("mediaId")
    private SinglePhysicalMedia media;
    @MapsId("customerId")
    @ManyToOne
    private Customer customer;

    private Date reservationDate;

    @EmbeddedId
    ReservationKey id;

    public Reservation(SinglePhysicalMedia spm, Customer customer, Date reservationDate) {
        this.media = spm;
        this.customer = customer;
        this.reservationDate = reservationDate;
    }
}
