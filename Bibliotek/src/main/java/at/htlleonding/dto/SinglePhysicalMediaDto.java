package at.htlleonding.dto;

import at.htlleonding.persistence.shop.entities.BillKey;
import at.htlleonding.persistence.shop.entities.LendingKey;
import at.htlleonding.persistence.shop.entities.ReservationKey;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SinglePhysicalMediaDto {
    private Integer id;

    private Integer physicalMediaId;

    private LocalDate purchaseDate;

    private Boolean forSale = false;

    private Boolean reserveable = false;

    private Boolean lendable = false;

    private List<BillKey> billIds = new ArrayList<>();

    private List<ReservationKey> reservationIds = new ArrayList<>();

    private List<Integer> lendingIds = new ArrayList<>();
}
