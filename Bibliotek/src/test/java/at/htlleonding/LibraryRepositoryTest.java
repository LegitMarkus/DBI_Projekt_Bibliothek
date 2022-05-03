package at.htlleonding;

import at.htlleonding.persistence.*;
import at.htlleonding.repository.LibraryRepository;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import at.htlleonding.repository.CRUDOperations;

import javax.inject.Inject;
import javax.persistence.EntityManager;

@QuarkusTest
class LibraryRepositoryTest {
    @Inject
<<<<<<< HEAD
    LibraryRepository target;
=======
    CRUDOperations target;
>>>>>>> main
    @Inject
    EntityManager em;

    private void createDigitaleMedienAndAuthor() {
        /*
        var a1 = new Author();
        a1.setVorname("George");
        a1.setNachname("Orwell");
        target.add(a1);

        var digitalesMedium = new DigitalMedia();
        digitalesMedium.setTitel("1984");
        target.add(digitalesMedium);

        var digitalesMedium2 = new DigitalMedia();
        digitalesMedium2.setTitel("10034");
        target.add(a1, digitalesMedium2);*/
    }

    @TestTransaction
    @Test
    public void callCreateBookAndAuthor_getByLastName_Orwell_getOrwellObject() {/*
        createDigitaleMedienAndAuthor();
        String nachname = "Orwell";
        var target = em.createQuery("select a from Author a where a.nachname like :name", Author.class).setParameter("name", nachname).getSingleResult();
        Assertions.assertNotNull(target);
        Assertions.assertEquals("Orwell", target.getNachname());
        */
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