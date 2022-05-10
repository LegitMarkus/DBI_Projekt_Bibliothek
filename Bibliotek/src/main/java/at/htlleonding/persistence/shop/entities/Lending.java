package at.htlleonding.persistence.shop.entities;

import at.htlleonding.persistence.DigitalMedia;
import at.htlleonding.persistence.SinglePhysicalMedia;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Lending {
    @EmbeddedId
    LendingKey id;

    @ManyToOne
    private SinglePhysicalMedia media;
    @ManyToOne
    private DigitalMedia digitalMedia;

    @MapsId("custommerId")
    @ManyToOne
    private Customer custommer;

    @Column(nullable = false)
    private Date lendingDate;

    @Column(nullable = false)
    private Date returnDate;

    @Column
    private Integer extension = 0;

    public Lending(SinglePhysicalMedia media, Customer customer, Date lendingDate, Date returnDate) {
        this.media = media;
        this.custommer = customer;
        this.lendingDate = lendingDate;
        this.returnDate = returnDate;
    }
}
