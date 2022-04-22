package at.htlleonding.logic;

import at.htlleonding.dto.AuthorDto;
import at.htlleonding.repository.CRUDOperations;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class LibraryLogicTest {
    /* VON MOODLE
    @Inject
    LibraryMgmtLogic target;

    @Inject
    LibraryMgmtRepository repository;

    @TestTransaction
    @Test
    public void authorDTO_addUsingLogic_entityPersisted() {
        var authorDTO = new AuthorDTO();
        authorDTO.setDateBirth(LocalDate.of(1980, 1, 1));
        authorDTO.setDateDeath(LocalDate.of(2000, 1, 1));
        authorDTO.setFirstName("John");
        authorDTO.setLastName("Doe");

        var result = target.addAuthor(authorDTO);
        Assertions.assertNotEquals(0, result);

        target.flushAndClear();
        var authorDB = repository.getAuthor(result);
        Assertions.assertNotNull(authorDB);
        Assertions.assertEquals(authorDTO.getLastName(), authorDB.getLastName());
    }
    */
    @Inject
    LibraryMgmtLogic target;

    @Inject
    CRUDOperations repository;

    @TestTransaction
    @Test
    public void authorDTO_addUsingLogic_entityPersisted() {
        var authorDTO = new AuthorDto();
        //authorDTO.setDateBirth(LocalDate.of(1980, 1, 1));
        //authorDTO.setDateDeath(LocalDate.of(2000, 1, 1));
        authorDTO.setFirstname("John");
        authorDTO.setLastname("Doe");

        //TODO Noch ned implementiert in Logic Implementieren
        //var result = target.add(authorDTO);
        //Assertions.assertNotEquals(0, result);

        //target.flushAndClear();
        //var authorDB = repository.getAuthor(result);
        //Assertions.assertNotNull(authorDB);
        //Assertions.assertEquals(authorDTO.getLastname(), authorDB.getLastName());
    }
    //TODO Alle anderen ENTITIES in der Logic implementieren
}