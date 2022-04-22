package at.htlleonding.dto.shop.entities;

import at.htlleonding.persistence.SinglePhysicalMedia;
import at.htlleonding.persistence.shop.entities.Customer;
import at.htlleonding.persistence.shop.entities.ReservationKey;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDto {
    private Integer mediaId;

    private Integer customerId;

    private Date reservationDate;

    private ReservationKey id;
}
