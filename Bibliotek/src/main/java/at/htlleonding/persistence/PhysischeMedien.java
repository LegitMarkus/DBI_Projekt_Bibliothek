package at.htlleonding.persistence;

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
public class PhysischeMedien extends Medien{
    @Column(nullable = false)
    private Integer gesammtanzahl;
    @Column(nullable = false)
    private Integer verleih;
    @Column(nullable = false)
    private Integer freihandbereich;
    @Column(nullable = false)
    private boolean ausleihen;
    //@Column(nullable = false)
    //private boolean mitarbeiterverkauffreigabe;
    @Column
    private String Signature;

    @ManyToMany
    private Set<Author> authors = new HashSet<>();

    @OneToMany
    private Set<SinglePhysicalMedium> einzelneMedien;
}
