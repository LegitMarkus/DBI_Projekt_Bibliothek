package at.htlleonding.persistence;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String keyword;

    @OneToMany
    private Set<Book> booksOfGenre = new HashSet<>();

    public Genre(String keyword) {
        this.keyword = keyword;
    }

    public Genre() {
    }

    public Integer getId() { return id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Set<Book> getBooks() {
        return booksOfGenre;
    }
}
