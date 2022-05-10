package at.htlleonding.persistence.logic;

import at.htlleonding.dto.AudioBookDto;
import at.htlleonding.dto.AuthorDto;
import at.htlleonding.dto.BookDto;
import at.htlleonding.logic.LibraryMgmtLogic;
import at.htlleonding.logic.model.controller.*;
import at.htlleonding.logic.model.controller.shop.logic.*;
import at.htlleonding.persistence.Author;
import at.htlleonding.persistence.Book;
import at.htlleonding.persistence.SinglePhysicalMedia;
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
    @Inject
    CRUDOperations repository;
    @Inject
    BillLogic billLogic;
    @Inject
    CustomerLogic customerLogic;
    @Inject
    LendingLogic lendingLogic;
    @Inject
    ReservationLogic reservationLogic;
    @Inject
    StaffLogic staffLogic;
    @Inject
    AudioBookLogic audioBookLogic;
    @Inject
    AuthorLogic authorLogic;
    @Inject
    BookLogic bookLogic;
    @Inject
    DigitalMediaLogic digitalMediaLogic;
    @Inject
    EBookLogic eBookLogic;
    @Inject
    GenreLogic genreLogic;
    @Inject
    LanguageLogic languageLogic;
    @Inject
    MagazineLogic magazineLogic;
    @Inject
    MediaLogic mediaLogic;
    @Inject
    NewspaperLogic newspaperLogic;
    @Inject
    PhysicalMediaLogic physicalMediaLogic;
    @Inject
    PublisherLogic publisherLogic;
    @Inject
    SinglePhysicalMediaLogic singlePhysicalMediaLogic;
    @Inject
    SpeakerLogic speakerLogic;
    @Inject
    TopicLogic topicLogic;


    @Test
    @TestTransaction
    public void addPaperBookWithOneAuthor_makeRentable_canBeRented()
    {
        String firstname = "Robert";
        String lastname = "Lenz";

        var authorDto = new AuthorDto();
        authorDto.setFirstname(firstname);
        authorDto.setLastname(lastname);
        authorLogic.insert(authorDto);
        authorLogic.flushAndClear();

        var findAuthor = authorLogic.getByName(firstname, lastname);

        var bookDto = new BookDto();
        bookDto.getAuthorIds().add(findAuthor.getId());
        bookDto.setTitle("Hallo");
        bookDto.setBorrowing(5);
        bookDto.setFreehandArea(5);
        bookDto.setTranslation(false);
        bookLogic.insert(bookDto);
        bookLogic.flushAndClear();

        var bookDatabase = bookLogic.getByName("Hallo");

    }

    @Test
    @TestTransaction
    public void addPaperBookWithThreeAuthors_makeRentable_canBeRented()
    {
        String firstname = "Robert1";
        String lastname = "Lenz1";

        var authorDto = new AuthorDto();
        authorDto.setFirstname(firstname);
        authorDto.setLastname(lastname);
        authorLogic.insert(authorDto);
        authorLogic.flushAndClear();

        String firstname2 = "Robert2";
        String lastname2 = "Lenz2";

        var authorDto2 = new AuthorDto();
        authorDto2.setFirstname(firstname2);
        authorDto2.setLastname(lastname2);
        authorLogic.insert(authorDto2);
        authorLogic.flushAndClear();

        String firstname3 = "Robert3";
        String lastname3 = "Lenz3";

        var authorDto3 = new AuthorDto();
        authorDto3.setFirstname(firstname3);
        authorDto3.setLastname(lastname3);
        authorLogic.insert(authorDto3);
        authorLogic.flushAndClear();

        var findAuthor = authorLogic.getByName(firstname, lastname);
        var findAuthor2 = authorLogic.getByName(firstname2, lastname2);
        var findAuthor3 = authorLogic.getByName(firstname3, lastname3);


        var bookDto = new BookDto();
        bookDto.getAuthorIds().add(findAuthor.getId());
        bookDto.getAuthorIds().add(findAuthor2.getId());
        bookDto.getAuthorIds().add(findAuthor3.getId());

        var title = "Hallo2";

        bookDto.setTitle(title);
        bookDto.setBorrowing(5);
        bookDto.setFreehandArea(5);
        bookDto.setTranslation(false);
        bookLogic.insert(bookDto);
        bookLogic.flushAndClear();

        var bookDatabase = bookLogic.getByName(title);

    }

    @Test
    @TestTransaction
    public void addThreeCopiesOfPaperBookWithThreeAuthors_makeRentable_canBeRented()
    {
        Assertions.fail("Not implemented yet!!");
    }

    @Test
    @TestTransaction
    public void addNewspaperWithOneAuthor_makeRentable_canBeRented()
    {
        Assertions.fail("Not implemented yet!!");
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