package at.htlleonding.dto.shop.entities;

import at.htlleonding.persistence.SinglePhysicalMedia;
import at.htlleonding.persistence.shop.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BillDto {
    private String id;

    private Integer mediaId;

    private Integer custommerId;

    private Integer price;
}
