package at.htlleonding.persistence.shop.entities;

import at.htlleonding.persistence.SinglePhysicalMedia;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Bill {
    @EmbeddedId
    BillKey id;

    @ManyToOne
    @MapsId("mediaId")
    private SinglePhysicalMedia media;
    @MapsId("custommerId")
    @ManyToOne
    private Customer custommer;

    @Column(nullable = false)
    private Integer price;

    public Bill(SinglePhysicalMedia media, Customer customer, Integer price) {
        this.media = media;
        this.custommer = customer;
        this.price = price;
    }
}
