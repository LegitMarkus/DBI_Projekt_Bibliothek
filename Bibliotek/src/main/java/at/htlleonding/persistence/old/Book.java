package at.htlleonding.persistence.old;

import javax.persistence.*;
import java.util.Set;
import java.util.HashSet;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = false)
    private String title;

    public Set<BookAuthor> getAssocAuthors() {
        return myAuthors;
    }

    @OneToMany(mappedBy = "book")
    private Set<BookAuthor> myAuthors = new HashSet<>();

    @ManyToMany()
    private Set<Topic> topics = new HashSet<>();

    @ManyToOne
    private Genre genre;

    public Book() {
    }

    public Book(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Author> getAuthors() {
        var result = new HashSet<Author>();
        for(BookAuthor ba : myAuthors) {
            result.add(ba.getAuthor());
        }
        return result;
    }

    public Set<Topic> getTopics() {
        return topics;
    }

    public void setGenre(Genre g) {
        genre = g;
    }

    public Genre getGenre() {
        return genre;
    }
}
