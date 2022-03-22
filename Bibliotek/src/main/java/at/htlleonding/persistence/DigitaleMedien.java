package at.htlleonding.persistence;

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
public class DigitaleMedien extends Medien{
    @ManyToOne
    private Genre genre;

    @ManyToMany
    @JoinColumn
    private Set<Author> authors = new HashSet<Author>();
}
