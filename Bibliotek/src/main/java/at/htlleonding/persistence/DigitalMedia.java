package at.htlleonding.persistence;

import at.htlleonding.persistence.shop.entities.Lending;
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
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public class DigitalMedia extends Media {
    @Column
    private String url;

    @OneToMany
    private Set<Lending> lendings = new HashSet<>();
}
