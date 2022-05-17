package at.htlleonding.persistence.shop.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String customerNumber;

    @Column(nullable = false, length = 50)
    private String firstName;

    @Column(nullable = false, length = 50)
    private  String lastName;

    @OneToMany
    private Set<Reservation> reservations = new HashSet<>();

    @OneToMany(mappedBy = "custommer")
    private Set<Lending> lendings = new HashSet<>();

    @OneToMany
    private Set<Bill> bills = new HashSet<>();

}
