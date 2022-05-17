package at.htlleonding.persistence.shop.entities;

import at.htlleonding.persistence.PhysicalMedia;
import at.htlleonding.persistence.SinglePhysicalMedia;
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
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    //@MapsId("mediaId")
    private PhysicalMedia media;
    //@MapsId("customerId")
    @ManyToOne
    private Customer customer;

    private Date reservationDate;

    //@EmbeddedId
    //ReservationKey id;

    public Reservation(PhysicalMedia spm, Customer customer, Date reservationDate) {
        this.media = spm;
        this.customer = customer;
        this.reservationDate = reservationDate;
    }
}
