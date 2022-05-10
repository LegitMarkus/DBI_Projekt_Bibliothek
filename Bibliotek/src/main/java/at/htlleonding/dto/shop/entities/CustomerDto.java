package at.htlleonding.dto.shop.entities;

import at.htlleonding.persistence.shop.entities.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private Integer id;

    private String customerNumber;

    private String firstName;

    private  String lastName;

    private List<ReservationKey> reservationIds = new ArrayList<>();

    private List<LendingKey> lendingIds = new ArrayList<>();

    private List<BillKey> billIds = new ArrayList<>();
}
