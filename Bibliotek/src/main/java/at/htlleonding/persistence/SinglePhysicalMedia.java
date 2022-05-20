package at.htlleonding.persistence;

import at.htlleonding.persistence.shop.entities.Lending;
import at.htlleonding.persistence.shop.entities.Bill;
import at.htlleonding.persistence.shop.entities.Reservation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
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
    @JoinColumn(name = "physicalMedia_id")
    private PhysicalMedia physicalMedia;

    @Column
    private LocalDate purchaseDate;

    @Column
    private Boolean forSale = false;

    @Column
    private Boolean reserveable = false;

    @Column
    private Boolean lendable = false;

    @OneToMany
    private Set<Bill> bills = new HashSet<>();

    @OneToMany(mappedBy = "media")
    private Set<Lending> lendings = new HashSet<>();
}
