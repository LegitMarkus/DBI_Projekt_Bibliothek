package at.htlleonding.dto.shop.entities;

import at.htlleonding.persistence.shop.entities.Bill;
import at.htlleonding.persistence.shop.entities.Lending;
import at.htlleonding.persistence.shop.entities.Reservation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustommerDto {
    private Integer id;

    private String customerNumber;

    private String firstName;

    private  String lastName;

    private List<Integer> reservationIds;

    private List<Integer> lendingIds;

    private List<Integer> billIds;
}
