package at.htlleonding.persistence;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = false)
    private String title;

    @Column
    private Date publisherDate;

    @ManyToOne
    private Publisher publisher;

    @Column
    private boolean translation;

    @ManyToOne
    private Language language;

    @ManyToMany
    private Set<Topic> topics = new HashSet<>();

    @ManyToOne
    private Genre genre;

    @ManyToMany
    private Set<Author> authors = new HashSet<Author>();

}
