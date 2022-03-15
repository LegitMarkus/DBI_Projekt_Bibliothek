package at.htlleonding.persistence;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public class Physische_Medien extends Medien{
    @Column(nullable = false)
    private Integer gesammtanzahl;
    @Column(nullable = false)
    private Integer verleih;
    @Column(nullable = false)
    private Integer freihandbereich;
    @Column(nullable = false)
    private boolean mitarbeiterverkauffreigabe;

    @ManyToMany
    private Set<Author> authors;
}
