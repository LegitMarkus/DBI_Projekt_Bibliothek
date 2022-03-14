package at.htlleonding.persistence.old;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany()
    private Set<Book> booksOfTopic = new HashSet<>();

    @Column
    private String keyword;

    public Topic() {}
    public Topic(String keyword) {
        this.keyword = keyword;
    }

    public Integer getId() {
        return id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Set<Book> getBooks() { return booksOfTopic;
    }
}
