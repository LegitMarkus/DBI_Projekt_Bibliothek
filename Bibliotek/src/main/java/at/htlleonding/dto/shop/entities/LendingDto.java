package at.htlleonding.dto.shop.entities;

import at.htlleonding.persistence.SinglePhysicalMedia;
import at.htlleonding.persistence.shop.entities.Customer;
import at.htlleonding.persistence.shop.entities.LendingKey;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LendingDto {

    private LendingKey id;

    private Integer mediaId;

    private Integer custommerId;

    private Date lendingDate;

    private Date returnDate;

    private Integer extension;
}
