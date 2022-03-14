package at.htlleonding.persistence.old;

import javax.persistence.*;
import java.util.Objects;


@Embeddable
public class BookAuthorKey implements java.io.Serializable {

    @Column
    Integer authorId;

    @Column
    Integer bookId;

    protected BookAuthorKey() {}

    public BookAuthorKey(Integer bookId, Integer authorId) {
        this.authorId = authorId;
        this.bookId = bookId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookAuthorKey that = (BookAuthorKey) o;
        return Objects.equals(authorId, that.authorId) && Objects.equals(bookId, that.bookId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorId, bookId);
    }
}
