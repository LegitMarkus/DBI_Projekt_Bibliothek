package at.htlleonding.persistence;

import javax.persistence.*;

@Entity
public class BookAuthor {

    @EmbeddedId
    BookAuthorKey id;

    @ManyToOne
    @MapsId("authorId")
    Author author;

    @ManyToOne
    @MapsId("bookId")
    Book book;

    @Column
    boolean isPrimaryAuthor;

    public BookAuthor() {}

    public BookAuthor(Book book, Author author, boolean isPrimaryAuthor) {
        this.id = new BookAuthorKey(book.getId(), author.getId());
        this.author = author;
        this.book = book;
        this.isPrimaryAuthor = isPrimaryAuthor;
    }

    public BookAuthorKey getId() {
        return id;
    }

    public void setId(BookAuthorKey id) {
        this.id = id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public boolean isPrimaryAuthor() {
        return isPrimaryAuthor;
    }

    public void setPrimaryAuthor(boolean primaryAuthor) {
        isPrimaryAuthor = primaryAuthor;
    }
}
