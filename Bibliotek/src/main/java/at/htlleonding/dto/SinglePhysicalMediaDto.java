package at.htlleonding.dto;

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

    private List<Integer> billIds;

    private List<Integer> reservationIds;

    private List<Integer> lendingIds;
}
