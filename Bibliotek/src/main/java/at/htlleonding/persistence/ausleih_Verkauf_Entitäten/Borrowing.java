package at.htlleonding.persistence.ausleih_Verkauf_Entitäten;

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
public class Borrowing {
    @EmbeddedId
    BorrowingKey id;

    @ManyToOne
    @MapsId("mediaId")
    private SinglePhysicalMedia media;
    @MapsId("custommerId")
    @ManyToOne
    private Customer custommer;

    @Column(nullable = false)
    private Date borrowingDate;

    @Column(nullable = false)
    private Date returnDate;

    @Column
    private Integer extension = 0;

    public Borrowing(SinglePhysicalMedia media, Customer customer, Date borrowingDate, Date returnDate) {
        this.media = media;
        this.custommer = customer;
        this.borrowingDate = borrowingDate;
        this.returnDate = returnDate;
    }
}
