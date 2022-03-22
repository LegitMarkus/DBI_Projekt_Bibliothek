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

    @TestTransaction
    @Test
    public void callCreateBookAndAuthor_getByLastName_Orwell_getOrwellObject() {
        createDigitaleMedienAndAuthor();
        String nachname = "Orwell";
        var target = em.createQuery("select a from Author a where a.nachname like :name", Author.class).setParameter("name", nachname).getSingleResult();
        Assertions.assertNotNull(target);
        Assertions.assertEquals("Orwell", target.getNachname());
    }
/*
    @TestTransaction
    @Test
    public void createDigitaleMedien_createNewMedium_throwExeption() {
        Assertions.assertThrows(NullPointerException, () -> {
            var digitalesMedium2 = new DigitaleMedien();
            digitalesMedium2.setTitel("10034");
            target.add(digitalesMedium2);
        });
    }
    
 */
}