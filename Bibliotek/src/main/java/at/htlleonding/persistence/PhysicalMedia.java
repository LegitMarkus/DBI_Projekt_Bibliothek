package at.htlleonding.persistence;

import at.htlleonding.persistence.shop.entities.Reservation;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public class PhysicalMedia extends Media {
    @Column(nullable = false)
    private Integer totalNumber;
    @Column(nullable = false)
    private Integer borrowing;
    @Column(nullable = false)
    private Integer freehandArea;
    @Column
    private String Signature;

    @ManyToMany
    private Set<Author> authors = new HashSet<>();

    @OneToMany
    private Set<SinglePhysicalMedia> singlePhysicalMedia = new HashSet<>();

    @OneToMany
    private Set<Reservation> reservations = new HashSet<>();
}
