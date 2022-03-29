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
    private Set<SinglePhysicalMedia> einzelneMedien;
}
