package at.htlleonding.persistence.logic;

import at.htlleonding.dto.AuthorDto;
import at.htlleonding.logic.LibraryMgmtLogic;
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
        authorDTO.setBirthDate(LocalDate.of(1980, 1, 1));
        authorDTO.setDeathDate(LocalDate.of(2000, 1, 1));
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

    //#################################################################################################
    //Abgabe A5: Entitäten, Businesslogic und Unit Tests für Verwaltung, Ausleihe und Verkauf.
    //Geöffnet: Wednesday, 20. April 2022, 00:00
    //Fällig: Thursday, 26. May 2022, 23:59

    /*
    Add rentable items to the library, of each media type, with multiple authors and attributes.
    Verify that these items can be rented.
    */
    @Test
    @TestTransaction
    public void addPaperBookWithOneAuthor_makeRentable_canBeRented()
    {
        Assertions.fail("Not implemented yet");
    }

    @Test
    @TestTransaction
    public void addPaperBookWithThreeAuthors_makeRentable_canBeRented()
    {
        Assertions.fail("Not implemented yet");
    }

    @Test
    @TestTransaction
    public void addThreeCopiesOfPaperBookWithThreeAuthors_makeRentable_canBeRented()
    {
        Assertions.fail("Not implemented yet");
    }

    @Test
    @TestTransaction
    public void addNewspaperWithOneAuthor_makeRentable_canBeRented()
    {
        Assertions.fail("Not implemented yet");
    }

    @Test
    @TestTransaction
    public void addAudioBookWithOneAuthor_makeRentable_canBeRented()
    {
        Assertions.fail("Not implemented yet");
    }

    @Test
    @TestTransaction
    public void addEBookWithOneAuthor_makeRentable_canBeRented()
    {
        Assertions.fail("Not implemented yet");
    }

    @Test
    @TestTransaction
    public void addJournalWithOneAuthor_makeRentable_canBeRented()
    {
        Assertions.fail("Not implemented yet");
    }


    /*
     Add a library customer.
     Add a library employee.
     */
    @Test
    @TestTransaction
    public void addLibraryCustomer_isAvailable()
    {
        Assertions.fail("Not implemented yet");
    }

    @Test
    @TestTransaction
    public void addLibraryEmployee_isAvailable()
    {
        Assertions.fail("Not implemented yet");
    }

    /*
     Rent out, bring back, reserve and prolong.
     Verify state of rented items and customer's rent list.
    */
    @Test
    @TestTransaction
    public void customerRentsRentableItem_ItemIsRented()
    {
        Assertions.fail("Not implemented yet");
    }

    @Test
    @TestTransaction
    public void customerRentsOneOfThreeCopiesOfRentableItem_TwoRentableItemsRemain_CustomerHasRent()
    {
        Assertions.fail("Not implemented yet");
    }

    @Test
    @TestTransaction
    public void customerRentsThreeOfThreeCopiesOfRentableItem_TryRentAnother_RentNotPossible()
    {
        Assertions.fail("Not implemented yet");
    }

    @Test
    @TestTransaction
    public void customerOneItemOfEachMediaType_ItemsAreRented()
    {
        Assertions.fail("Not implemented yet");
    }

    @Test
    @TestTransaction
    public void setItemForSale_customerTriesToRent_RentNotPossible()
    {
        Assertions.fail("Not implemented yet");
    }

    @Test
    @TestTransaction
    public void setItemForOnDisplay_customerTriesToRent_RentNotPossible()
    {
        Assertions.fail("Not implemented yet");
    }

    @Test
    @TestTransaction
    public void customerRentsSingleAvailableItem_RentNotPossible_BringsBackItem_RentPossible()
    {
        Assertions.fail("Not implemented yet");
    }

    @Test
    @TestTransaction
    public void rentOutItemToCustomerA_customerBmakesReservation_CustomerAreturnsItem_RentPossibleOnlyForCustomerB()
    {
        Assertions.fail("Not implemented yet");
    }

    @Test
    @TestTransaction
    public void customerRentsItem_prolongsRentThreeTimes_customerCanOnlyProlongTwoTimes_rentalEndDate6weeksAhead()
    {
        Assertions.fail("Not implemented yet");
    }

    @Test
    @TestTransaction
    public void customerRentsItem_prolongsRentTwoTimes_EmployeeProlongsOneTime_rentalEndDate8weeksAhead()
    {
        Assertions.fail("Not implemented yet");
    }

    /*
      - Declare a library item to be for sale, it cannot be rented anymore.
      - Sell one library item to a customer, create invoice. Item cannot be rented anymore.
      - Sell some items of multiple books.
     */
    @Test
    @TestTransaction
    public void setItemForSale_cannotBeRented()
    {
        Assertions.fail("Not implemented yet");
    }

    @Test
    @TestTransaction
    public void setOneOfTwoItemsForSale_onlyOneCanBeRented()
    {
        Assertions.fail("Not implemented yet");
    }

    @Test
    @TestTransaction
    public void setThreeDifferentItemsForSale_CustomerBuys2_InvoiceHasTwoItems_OnlyOneItemForRent()
    {
        Assertions.fail("Not implemented yet");
    }
}