package at.htlleonding.dto;

import at.htlleonding.persistence.shop.entities.BillKey;
import at.htlleonding.persistence.shop.entities.LendingKey;
import at.htlleonding.persistence.shop.entities.ReservationKey;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SinglePhysicalMediaDto {
    private Integer id;

    private Integer physicalMediaId;

    private Date purchaseDate;

    private Boolean forSale = false;

    private List<BillKey> billIds;

    private List<ReservationKey> reservationIds;

    private List<LendingKey> lendingIds;
}
