package at.htlleonding;

import at.htlleonding.persistence.*;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import at.htlleonding.LibraryRepository.*;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;

import static org.junit.jupiter.api.Assertions.*;
@QuarkusTest
class LibraryRepositoryTest {
    @Inject
     LibraryRepository target;
    @Inject
    EntityManager em;

    private void createDigitaleMedienAndAuthor() {
        var a1 = new Author();
        a1.setVorname("George");
        a1.setNachname("Orwell");
        target.add(a1);

        var digitalesMedium = new DigitaleMedien();
        digitalesMedium.setTitel("1984");
        target.add(digitalesMedium);

        var digitalesMedium2 = new DigitaleMedien();
        digitalesMedium2.setTitel("10034");
        target.add(a1, digitalesMedium2);
    }
/*
    private void createPhysischeMedienAndAuthor() {
        var a1 = new Author();
        a1.setVorname("George");
        a1.setNachname("Orwell");
        target.add(a1);

        var physischeMedium = new Buch();
        physischeMedium.setFreihandbereich(1);
        physischeMedium.setGesammtanzahl(14);
        physischeMedium.setVerleih(5);
        physischeMedium.setTitel("1984");
        physischeMedium.setMitarbeiterverkauffreigabe(true);
        Genre genre = new Genre();
        physischeMedium.setGenre(genre);
        target.add(physischeMedium);

        var physischeMedium2 = new Buch();
        physischeMedium2.setFreihandbereich(1);
        physischeMedium2.setGesammtanzahl(14);
        physischeMedium2.setVerleih(5);
        physischeMedium.setTitel("10034");
        physischeMedium2.setMitarbeiterverkauffreigabe(true);
        Genre genre2 = new Genre();
        physischeMedium2.setGenre(genre2);
        target.add(a1,  physischeMedium2);
    }
*/
    @TestTransaction
    @Test
    public void callCreateDigitaleMedienAndAuthor_getByLastName_Orwell_getOrwellObject() {
        createDigitaleMedienAndAuthor();
        String nachname = "Orwell";
        var target = em.createQuery("select a from Author a where a.nachname like :name", Author.class).setParameter("name", nachname).getSingleResult();
        Assertions.assertNotNull(target);
        Assertions.assertEquals("Orwell", target.getNachname());
    }
/*
    @TestTransaction
    @Test
    public void callCreatePhysischeMedienAndAuthor_getByLastName_Orwell_getOrwellObject() {
        createPhysischeMedienAndAuthor();
        String nachname = "Orwell";
        var target = em.createQuery("select a from Author a where a.nachname like :name", Author.class).setParameter("name", nachname).getSingleResult();
        Assertions.assertNotNull(target);
        Assertions.assertEquals("Orwell", target.getNachname());
    }

 */

}