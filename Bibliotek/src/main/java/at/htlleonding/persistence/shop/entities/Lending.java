package at.htlleonding.persistence.shop.entities;

import at.htlleonding.persistence.DigitalMedia;
import at.htlleonding.persistence.PhysicalMedia;
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
    //@EmbeddedId
    //LendingKey id;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    //@MapsId("mediaId")
    private SinglePhysicalMedia media;

    //@MapsId("custommerId")
    @ManyToOne
    private Customer custommer;

    @Column(nullable = false)
    private Date lendingDate;

    @Column(nullable = false)
    private Date returnDate;

    @Column(nullable = false)
    private Boolean returned = false;

    @Column
    private Integer extension = 0;

    public Lending(SinglePhysicalMedia media, Customer customer, Date lendingDate, Date returnDate) {
        this.media = media;
        this.custommer = customer;
        this.lendingDate = lendingDate;
        this.returnDate = returnDate;
    }
}
