package at.htlleonding.persistence;

import at.htlleonding.persistence.shop.entities.Borrowing;
import at.htlleonding.persistence.shop.entities.Bill;
import at.htlleonding.persistence.shop.entities.Reservation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class SinglePhysicalMedia
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private PhysicalMedia physicalMedia;

    @Column
    private Date purchaseDate;

    @Column
    private Boolean forSale = false;

    @OneToMany
    private Set<Bill> bills = new HashSet<>();

    @OneToMany
    private Set<Reservation> reservations = new HashSet<>();

    @OneToMany
    private Set<Borrowing> borrowings = new HashSet<>();
}
