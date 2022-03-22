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
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String vorname;
    @Column(nullable = false, length = 50)
    private String nachname;

    @ManyToMany
    private Set<DigitaleMedien> digitaleMedien = new HashSet<DigitaleMedien>();

    @ManyToMany
    private Set<Buch> bucher = new HashSet<Buch>();
}
