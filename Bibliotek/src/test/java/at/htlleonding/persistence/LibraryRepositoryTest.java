package at.htlleonding.persistence;

import at.htlleonding.persistence.old.Author;
import at.htlleonding.persistence.old.Book;
import at.htlleonding.persistence.old.LibraryRepository;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.*;

import javax.inject.Inject;
import java.time.LocalDate;

@QuarkusTest
public class LibraryRepositoryTest {
    @Inject
    LibraryRepository target;

    private void createBookAndAuthor() {
        var a1 = new Author();
        a1.setDateDeath(LocalDate.of(1980, 01, 01));
        a1.setDateBirth(LocalDate.of(1940, 01, 01));
        a1.setFirstName("George");
        a1.setLastName("Orwell");

        target.add(a1);

        var b1 = new Book();
        b1.setTitle("1984");
        target.add(b1, a1);

        var b2 = new Book();
        b2.setTitle("Animal Farm");
        target.add(b2, a1);
    }

    @TestTransaction
    @Test
    public void callCreateBookAndAuthor_getByLastName_Orwell_getOrwellObject() {
        createBookAndAuthor();
        var target = this.target.getAuthorByLastName("Orwell");
        Assertions.assertNotNull(target);
        Assertions.assertEquals("George", target.getFirstName());
    }

    @TestTransaction
    @Test
    public void callCreateBookAndAuthor_getByLastName_Doe_getNULL() {
        createBookAndAuthor();
        var target = this.target.getAuthorByLastName("Doe");
        Assertions.assertNull(target);
    }

}
