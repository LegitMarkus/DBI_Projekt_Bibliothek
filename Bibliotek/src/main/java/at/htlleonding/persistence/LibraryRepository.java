package at.htlleonding.persistence;
///home/peter/src/dbi4/quarkus-hibernate-cmdline

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

// @Transactional
// https://quarkus.io/guides/transaction
// https://quarkus.io/guides/hibernate-orm
// Mark your CDI bean method as @Transactional and the EntityManager will enlist and flush at commit.
// Make sure to wrap methods modifying your database (e.g. entity.persist()) within a transaction.
// Marking a CDI bean method @Transactional will do that for you and make that method a transaction boundary.
// We recommend doing so at your application entry point boundaries like your REST endpoint controllers.

@ApplicationScoped
public class LibraryRepository {

    @Inject
    EntityManager entityManager;

    @Transactional
    public void add(Author a) {
        entityManager.persist(a);
    }

    @Transactional
    public void add(Book b) { entityManager.persist(b);  }

    @Transactional
    public void add(Book b, Author a) {
        add(b, a, true);
    }

    @Transactional
    public void add(Book b, Author a, boolean isPrimaryAuthor) {
        if(b.getId() == null) {
            add(b);
        }
        if(a.getId() == null) {
            add(a);
        }

        var assoc = new BookAuthor(b, a, isPrimaryAuthor);
        a.getAssocBooks().add(assoc);
        b.getAssocAuthors().add(assoc);

        entityManager.persist(assoc);
        entityManager.persist(a);
        entityManager.persist(b);
    }

    @Transactional
    public void add(Topic t) {
        entityManager.persist(t);
    }

    @Transactional
    public void add(Book b, Topic t) {
        if(b.getId() == null) {
            add(b);
        }
        if(t.getId() == null) {
            add(t);
        }

        b.getTopics().add(t);
        t.getBooks().add(b);

        entityManager.persist(b);
        entityManager.persist(t);
    }

    @Transactional
    public void add(Genre g) {
        entityManager.persist(g);
    }

    @Transactional
    public void add(Book b, Genre g) {
        if(b.getId() == null) {
            add(b);
        }
        if(g.getId() == null) {
            add(g);
        }

        b.setGenre(g);
        g.getBooks().add(b);

        entityManager.persist(b);
        entityManager.persist(g);
    }

    @Transactional
    public List<Author> getAllAuthors() {
        return
                entityManager
                        .createQuery("select a from Author a", Author.class)
                        .getResultList();
    }

    @Transactional
    public Author getAuthorByLastName(String lastName) {
        try {
            //TODO
            return null;
        }
        catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }


    @Transactional
    public Book getBook(String authorLastName, String title) {
        try {
            //TODO
            return null;
        }
        catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Transactional
    public Genre getGenre(String keyword) {
        try {
            //TODO
            return null;
        }
        catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Transactional
    public Topic getTopic(String keyword) {
        try {
            //TODO
            return null;
        }
        catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Transactional
    public List<Book> getAllBooks() {
        try {
            //TODO
            return null;
        }
        catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
