package at.htlleonding.persistence.logic;

import at.htlleonding.dto.*;
import at.htlleonding.dto.shop.entities.CustomerDto;
import at.htlleonding.dto.shop.entities.LendingDto;
import at.htlleonding.dto.shop.entities.StaffDto;
import at.htlleonding.dto.xml.WorksOfAuthorDto;
import at.htlleonding.logic.model.controller.*;
import at.htlleonding.logic.model.controller.shop.logic.*;
import at.htlleonding.repository.CRUDOperations;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import javax.inject.Inject;

import javax.transaction.Transactional;

import java.io.Reader;
import java.io.StringReader;


import static org.junit.jupiter.api.Assertions.*;

// When ALL TESTS are running at the same time, two of them don't work!
// Those two TESTS only work if they are running alone!
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

        var title = "Was will Putin?";

        var bookDto = new BookDto();
        bookDto.getAuthorIds().add(findAuthor.getId());
        bookDto.setTitle(title);
        bookDto.setBorrowing(5);
        bookDto.setFreehandArea(5);
        bookDto.setTranslation(false);
        bookLogic.insert(bookDto);
        bookLogic.flushAndClear();

        var bookDatabase = bookLogic.getByName(title);

        Assertions.assertEquals(bookDatabase.getTitle(), title);
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

        var title = "Was will Putin?";

        bookDto.setTitle(title);
        bookDto.setBorrowing(5);
        bookDto.setFreehandArea(5);
        bookDto.setTranslation(false);
        bookLogic.insert(bookDto);
        bookLogic.flushAndClear();

        var bookDatabase = bookLogic.getByName(title);

        Assertions.assertEquals(bookDatabase.getTitle(), title);
    }

    @Test
    @TestTransaction
    public void addThreeCopiesOfPaperBookWithThreeAuthors_makeRentable_canBeRented()
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

        var title1 = "Was will Putin?1";
        var title2 = "Was will Putin?2";
        var title3 = "Was will Putin?3";

        var bookDto1 = new BookDto();
        bookDto1.getAuthorIds().add(findAuthor.getId());
        bookDto1.getAuthorIds().add(findAuthor2.getId());
        bookDto1.getAuthorIds().add(findAuthor3.getId());

        bookDto1.setTitle(title1);
        bookDto1.setBorrowing(5);
        bookDto1.setFreehandArea(5);
        bookDto1.setTranslation(false);
        bookLogic.insert(bookDto1);
        bookLogic.flushAndClear();

        var bookDto2 = new BookDto();
        bookDto2.getAuthorIds().add(findAuthor.getId());
        bookDto2.getAuthorIds().add(findAuthor2.getId());
        bookDto2.getAuthorIds().add(findAuthor3.getId());

        bookDto2.setTitle(title2);
        bookDto2.setBorrowing(5);
        bookDto2.setFreehandArea(5);
        bookDto2.setTranslation(false);
        bookLogic.insert(bookDto2);
        bookLogic.flushAndClear();

        var bookDto3 = new BookDto();
        bookDto3.getAuthorIds().add(findAuthor.getId());
        bookDto3.getAuthorIds().add(findAuthor2.getId());
        bookDto3.getAuthorIds().add(findAuthor3.getId());

        bookDto3.setTitle(title3);
        bookDto3.setBorrowing(5);
        bookDto3.setFreehandArea(5);
        bookDto3.setTranslation(false);
        bookLogic.insert(bookDto3);
        bookLogic.flushAndClear();

        var bookDatabase1 = bookLogic.getByName(title1);
        var bookDatabase2 = bookLogic.getByName(title2);
        var bookDatabase3 = bookLogic.getByName(title3);

        Assertions.assertEquals(bookDatabase1.getTitle(), title1);
        Assertions.assertEquals(bookDatabase2.getTitle(), title2);
        Assertions.assertEquals(bookDatabase3.getTitle(), title3);

    }

    @Test
    @TestTransaction
    public void addNewspaperWithOneAuthor_makeRentable_canBeRented()
    {
        String firstname = "Robert";
        String lastname = "Lenz";

        var authorDto = new AuthorDto();
        authorDto.setFirstname(firstname);
        authorDto.setLastname(lastname);
        authorLogic.insert(authorDto);
        authorLogic.flushAndClear();

        var findAuthor = authorLogic.getByName(firstname, lastname);

        var title = "Was will Putin?";

        var newspaperDto = new NewspaperDto();
        newspaperDto.getAuthorIds().add(findAuthor.getId());
        newspaperDto.setTitle(title);
        newspaperDto.setBorrowing(5);
        newspaperDto.setFreehandArea(5);
        newspaperDto.setTranslation(false);
        newspaperLogic.insert(newspaperDto);
        newspaperLogic.flushAndClear();

        var newspaperDatabase = newspaperLogic.getByName(title);

        Assertions.assertEquals(newspaperDatabase.getTitle(), title);
    }

    @Test
    @TestTransaction
    public void addAudioBookWithOneAuthor_makeRentable_canBeRented()
    {
        String firstname = "Robert";
        String lastname = "Lenz";

        var authorDto = new AuthorDto();
        authorDto.setFirstname(firstname);
        authorDto.setLastname(lastname);
        authorLogic.insert(authorDto);
        authorLogic.flushAndClear();

        var findAuthor = authorLogic.getByName(firstname, lastname);

        var title = "Was will Putin?";

        var audioBookDto = new AudioBookDto();
        audioBookDto.getAuthorIds().add(findAuthor.getId());
        audioBookDto.setTitle(title);
        audioBookDto.setTranslation(false);
        audioBookLogic.insert(audioBookDto);
        audioBookLogic.flushAndClear();

        var audioBookDatabase = audioBookLogic.getByName(title);

        Assertions.assertEquals(audioBookDatabase.getTitle(), title);
    }

    @Test
    @TestTransaction
    public void addEBookWithOneAuthor_makeRentable_canBeRented()
    {
        String firstname = "Robert";
        String lastname = "Lenz";

        var authorDto = new AuthorDto();
        authorDto.setFirstname(firstname);
        authorDto.setLastname(lastname);
        authorLogic.insert(authorDto);
        authorLogic.flushAndClear();

        var findAuthor = authorLogic.getByName(firstname, lastname);

        var title = "Was will Putin?";

        var eBookDto = new EBookDto();
        eBookDto.getAuthorIds().add(findAuthor.getId());
        eBookDto.setTitle(title);
        eBookDto.setTranslation(false);
        eBookLogic.insert(eBookDto);
        eBookLogic.flushAndClear();

        var eBookDatabase = eBookLogic.getByName(title);

        Assertions.assertEquals(eBookDatabase.getTitle(), title);
    }

    @Test
    @TestTransaction
    public void addJournalWithOneAuthor_makeRentable_canBeRented()
    {
        String firstname = "Robert";
        String lastname = "Lenz";

        var authorDto = new AuthorDto();
        authorDto.setFirstname(firstname);
        authorDto.setLastname(lastname);
        authorLogic.insert(authorDto);
        authorLogic.flushAndClear();

        var findAuthor = authorLogic.getByName(firstname, lastname);

        var title = "Was will Putin?";

        var magazineDto = new MagazineDto();
        magazineDto.getAuthorIds().add(findAuthor.getId());
        magazineDto.setTitle(title);
        magazineDto.setBorrowing(5);
        magazineDto.setFreehandArea(5);
        magazineDto.setTranslation(false);
        magazineLogic.insert(magazineDto);
        magazineLogic.flushAndClear();

        var magazineDatabase = magazineLogic.getByName(title);

        Assertions.assertEquals(magazineDatabase.getTitle(), title);
    }


    /*
     Add a library customer.
     Add a library employee.
     */
    @Test
    @TestTransaction
    public void addLibraryCustomer_isAvailable()
    {
        var custommer = new StaffDto();
        custommer.setFirstName("Markus");
        custommer.setLastName("Schwarz");
        custommer.setCustomerNumber("1A35");

        customerLogic.insert(custommer);

        var custommerDatabase = customerLogic.getByCustommerNumber("1A35");

        Assertions.assertEquals("1A35", custommerDatabase.getCustomerNumber());
    }

    @Test
    @TestTransaction
    public void addLibraryEmployee_isAvailable()
    {
        var staff = new StaffDto();
        staff.setFirstName("Markus");
        staff.setLastName("Schwarz");
        staff.setCustomerNumber("1A35");
        staff.setEmail("test@gmail.com");
        staff.setSalary(1500);

        staffLogic.insert(staff);
    }

    /*
     Rent out, bring back, reserve and prolong.
     Verify state of rented items and customer's rent list.
    */
    @Test
    @TestTransaction
    public void customerRentsRentableItem_ItemIsRented()
    {
        var title = "Was will Putin?";

        var bookDto = new BookDto();
        bookDto.setTitle(title);
        bookDto.setBorrowing(3);
        bookDto.setFreehandArea(0);
        bookDto.setTranslation(false);
        bookLogic.insert(bookDto);
        bookLogic.flushAndClear();

        var customerNumber = "1A35";

        var customer = new CustomerDto();
        customer.setFirstName("Markus");
        customer.setLastName("Schwarz");
        customer.setCustomerNumber(customerNumber);
        customerLogic.insert(customer);
        customerLogic.flushAndClear();

        var customerDatabase = customerLogic.getByCustommerNumber(customerNumber);
        var bookDatabase = bookLogic.getByName(title);

        var lending = new LendingDto();
        lending.setCustommerId(customerDatabase.getId());
        lending.setMediaId(bookDatabase.getId());
        bookDatabase.setBorrowing(bookDatabase.getBorrowing() - 1);

    }

    @Test
    @TestTransaction
    public void customerRentsOneOfThreeCopiesOfRentableItem_TwoRentableItemsRemain_CustomerHasRent() throws BuisnessLogicException {
        var title = "Was will Putin?";
        // Einfügen in der DB
        var bookDto = new BookDto();
        bookDto.setTitle(title);
        bookDto.setBorrowing(3);
        bookDto.setFreehandArea(0);
        bookDto.setTranslation(false);
        bookLogic.insert(bookDto);

        var customerNumber = "1A35";

        var customer = new CustomerDto();
        customer.setFirstName("Arsham");
        customer.setLastName("Edalatkhah");
        customer.setCustomerNumber(customerNumber);
        customerLogic.insert(customer);

        customerLogic.rentBook(customerNumber, title);
        var bookDatabase = bookLogic.getByName(title);

        Assertions.assertEquals(2, bookDatabase.getBorrowing());
    }

    @Test
    @TestTransaction
    public void customerRentsThreeOfThreeCopiesOfRentableItem_TryRentAnother_RentNotPossible() throws BuisnessLogicException {
        var title = "Was will Putin?";

        var bookDto = new BookDto();
        bookDto.setTitle(title);
        bookDto.setBorrowing(3);
        bookDto.setFreehandArea(0);
        bookDto.setTranslation(false);
        bookLogic.insert(bookDto);

        var customerNumber = "1A35";

        var customer = new CustomerDto();
        customer.setFirstName("Markus");
        customer.setLastName("Schwarz");
        customer.setCustomerNumber(customerNumber);
        customerLogic.insert(customer);

        customerLogic.rentBook(customerNumber, title);
        customerLogic.rentBook(customerNumber, title);
        customerLogic.rentBook(customerNumber, title);

        var bookDatabase = bookLogic.getByName(title);

        Assertions.assertEquals(0, bookDatabase.getBorrowing());
    }

    @Test
    @TestTransaction
    public void customerOneItemOfEachMediaType_ItemsAreRented() throws BuisnessLogicException
    {
        var customerNumber = "1A35";

        var customer = new CustomerDto();
        customer.setFirstName("Markus");
        customer.setLastName("Schwarz");
        customer.setCustomerNumber(customerNumber);
        customerLogic.insert(customer);
        customerLogic.flushAndClear();

        var title = "Was will Putin?";

        var bookDto = new BookDto();
        bookDto.setTitle(title);
        bookDto.setBorrowing(3);
        bookDto.setFreehandArea(0);
        bookDto.setTranslation(false);
        bookLogic.insert(bookDto);
        bookLogic.flushAndClear();

        var newspaperDto = new NewspaperDto();
        newspaperDto.setTitle(title);
        newspaperDto.setBorrowing(3);
        newspaperDto.setFreehandArea(0);
        newspaperDto.setTranslation(false);
        newspaperLogic.insert(newspaperDto);
        newspaperLogic.flushAndClear();

        var magazineDto = new MagazineDto();
        magazineDto.setTitle(title);
        magazineDto.setBorrowing(3);
        magazineDto.setFreehandArea(0);
        magazineDto.setTranslation(false);
        magazineLogic.insert(magazineDto);
        magazineLogic.flushAndClear();

        customerLogic.rentBook(customerNumber, title);
        customerLogic.rentNewspaper(customerNumber, title);
        customerLogic.rentMagazine(customerNumber, title);

        var audioBookDto = new AudioBookDto();
        audioBookDto.setTitle(title);
        audioBookDto.setTranslation(false);
        audioBookLogic.insert(audioBookDto);
        audioBookLogic.flushAndClear();

        var eBookDto = new EBookDto();
        eBookDto.setTitle(title);
        eBookDto.setTranslation(false);
        eBookLogic.insert(eBookDto);
        eBookLogic.flushAndClear();

        customerLogic.rentAudioBook(customerNumber, title);
        customerLogic.rentEBook(customerNumber, title);
    }

    @Test
    @TestTransaction
    public void setItemForSale_customerTriesToRent_RentNotPossible()
    {
        var customerNumber = "1A35";

        var customer = new CustomerDto();
        customer.setFirstName("Markus");
        customer.setLastName("Schwarz");
        customer.setCustomerNumber(customerNumber);
        customerLogic.insert(customer);
        customerLogic.flushAndClear();

        var title = "Was will Putin?";

        var bookDto = new BookDto();
        bookDto.setTitle(title);
        bookDto.setBorrowing(1);
        bookDto.setFreehandArea(0);
        bookDto.setTranslation(false);
        bookLogic.insert(bookDto);
        bookLogic.flushAndClear();

        singlePhysicalMediaLogic.setBookForSale(title, 1);

        Assertions.assertThrows(BuisnessLogicException.class, () -> {
            customerLogic.rentBook(customerNumber, title);
        });
    }

    @Test
    @TestTransaction
    public void setItemForOnDisplay_customerTriesToRent_RentNotPossible()
    {
        var customerNumber = "1A35";

        var customer = new CustomerDto();
        customer.setFirstName("Markus");
        customer.setLastName("Schwarz");
        customer.setCustomerNumber(customerNumber);
        customerLogic.insert(customer);
        customerLogic.flushAndClear();

        var title = "Was will Putin?";

        var bookDto = new BookDto();
        bookDto.setTitle(title);
        bookDto.setBorrowing(1);
        bookDto.setFreehandArea(0);
        bookDto.setTranslation(false);
        bookLogic.insert(bookDto);
        bookLogic.flushAndClear();

        singlePhysicalMediaLogic.SetOnDisplay(title, 1);

        var findBook = bookLogic.getByName(title);

        assertEquals(1, findBook.getFreehandArea());
    }

    // THIS TEST WORKS! THIS TEST WORKS!  THIS TEST WORKS!  THIS TEST WORKS!
    // For some reason this test does not work when ALL TESTS run at the same time
    // It only works if this test is the only test running!
    @Test
    @TestTransaction
    public void customerRentsSingleAvailableItem_RentNotPossible_BringsBackItem_RentPossible() throws BuisnessLogicException {
        var customerNumber = "1A35";

        var customer = new CustomerDto();
        customer.setFirstName("Markus");
        customer.setLastName("Schwarz");
        customer.setCustomerNumber(customerNumber);
        customerLogic.insert(customer);

        var title = "Was will Putin?";

        var bookDto = new BookDto();
        bookDto.setTitle(title);
        bookDto.setBorrowing(1);
        bookDto.setFreehandArea(0);
        bookDto.setTranslation(false);
        bookLogic.insert(bookDto);

        var lending = customerLogic.rentBook(customerNumber, title);
        //var findBook = bookLogic.getByName(title);

        Assertions.assertThrows(BuisnessLogicException.class, () -> {
            customerLogic.rentBook(customerNumber, title);
        });
        lendingLogic.returnBook(lending);
        customerLogic.rentBook(customerNumber, title);
    }

    // THIS TEST WORKS! THIS TEST WORKS!  THIS TEST WORKS!  THIS TEST WORKS!
    // For some reason this test does not work when ALL TESTS run at the same time
    // It only works if this test is the only test running!
    @Test
    @TestTransaction
    public void rentOutItemToCustomerA_customerBmakesReservation_CustomerAreturnsItem_RentPossibleOnlyForCustomerB() throws BuisnessLogicException {
        var customerNumber = "1A35";

        var customer = new CustomerDto();
        customer.setFirstName("Markus");
        customer.setLastName("Schwarz");
        customer.setCustomerNumber(customerNumber);
        customerLogic.insert(customer);

        var title = "Was will Putin?";

        var bookDto = new BookDto();
        bookDto.setTitle(title);
        bookDto.setBorrowing(1);
        bookDto.setFreehandArea(0);
        bookDto.setTranslation(false);
        bookLogic.insert(bookDto);

        var lending = customerLogic.rentBook(customerNumber, title);

        var customerB = new CustomerDto();
        var customerNumberB = "1B35";
        customerB.setFirstName("Markus");
        customerB.setLastName("Schwarz");
        customerB.setCustomerNumber(customerNumberB);
        customerLogic.insert(customerB);

        reservationLogic.reserveBook(customerNumberB, title);
        lendingLogic.returnBook(lending);

        var customerC = new CustomerDto();
        var customerNumberC = "1C35";
        customerC.setFirstName("Markus");
        customerC.setLastName("Schwarz");
        customerC.setCustomerNumber(customerNumberC);
        customerLogic.insert(customerC);

        Assertions.assertThrows(BuisnessLogicException.class, () -> {
            customerLogic.rentBook(customerNumberC, title);
        });
        customerLogic.rentBook(customerNumberB, title);
    }

    @Test
    @TestTransaction
    public void customerRentsItem_prolongsRentThreeTimes_customerCanOnlyProlongTwoTimes_rentalEndDate6weeksAhead() throws BuisnessLogicException {
        var customerNumber = "1A35";

        var customer = new CustomerDto();
        customer.setFirstName("Markus");
        customer.setLastName("Schwarz");
        customer.setCustomerNumber(customerNumber);
        customerLogic.insert(customer);

        var title = "Was will Putin?";

        var bookDto = new BookDto();
        bookDto.setTitle(title);
        bookDto.setBorrowing(1);
        bookDto.setFreehandArea(0);
        bookDto.setTranslation(false);
        bookLogic.insert(bookDto);

        var lending = customerLogic.rentBook(customerNumber, title);
        lendingLogic.prolongRentedItemCustomer(lending);
        lendingLogic.prolongRentedItemCustomer(lending);
        Assertions.assertThrows(BuisnessLogicException.class, () -> {
            lendingLogic.prolongRentedItemCustomer(lending);
        });
    }

    @Test
    @TestTransaction
    public void customerRentsItem_prolongsRentTwoTimes_EmployeeProlongsOneTime_rentalEndDate8weeksAhead() throws BuisnessLogicException {
        var customerNumber = "1A35";

        var customer = new CustomerDto();
        customer.setFirstName("Markus");
        customer.setLastName("Schwarz");
        customer.setCustomerNumber(customerNumber);
        customerLogic.insert(customer);

        var title = "Was will Putin?";

        var bookDto = new BookDto();
        bookDto.setTitle(title);
        bookDto.setBorrowing(1);
        bookDto.setFreehandArea(0);
        bookDto.setTranslation(false);
        bookLogic.insert(bookDto);

        var lending = customerLogic.rentBook(customerNumber, title);
        lendingLogic.prolongRentedItemCustomer(lending);
        lendingLogic.prolongRentedItemCustomer(lending);
        lendingLogic.prolongRentedItemEmpl(lending);
    }

    /*
      - Declare a library item to be for sale, it cannot be rented anymore.
      - Sell one library item to a customer, create invoice. Item cannot be rented anymore.
      - Sell some items of multiple books.
     */
    @Test
    @TestTransaction
    public void setItemForSale_cannotBeRented() throws BuisnessLogicException {
        var customerNumber = "1A35";

        var customer = new CustomerDto();
        customer.setFirstName("Markus");
        customer.setLastName("Schwarz");
        customer.setCustomerNumber(customerNumber);
        customerLogic.insert(customer);

        var title = "Was will Putin?";

        var bookDto = new BookDto();
        bookDto.setTitle(title);
        bookDto.setBorrowing(1);
        bookDto.setFreehandArea(0);
        bookDto.setTranslation(false);
        bookLogic.insert(bookDto);

        singlePhysicalMediaLogic.setForSale(title, 1);
        Assertions.assertThrows(BuisnessLogicException.class, () -> {
            customerLogic.rentBook(customerNumber, title);
        });
    }

    @Test
    @TestTransaction
    public void setOneOfTwoItemsForSale_onlyOneCanBeRented() throws BuisnessLogicException {
        var customerNumber = "1A35";

        var customer = new CustomerDto();
        customer.setFirstName("Markus");
        customer.setLastName("Schwarz");
        customer.setCustomerNumber(customerNumber);
        customerLogic.insert(customer);

        var title = "Was will Putin?";

        var bookDto = new BookDto();
        bookDto.setTitle(title);
        bookDto.setBorrowing(2);
        bookDto.setFreehandArea(0);
        bookDto.setTranslation(false);
        bookLogic.insert(bookDto);

        singlePhysicalMediaLogic.setForSale(title, 1);
        customerLogic.rentBook(customerNumber, title);
        Assertions.assertThrows(BuisnessLogicException.class, () -> {
            customerLogic.rentBook(customerNumber, title);
        });
    }

    @Test
    @TestTransaction
    public void setThreeDifferentItemsForSale_CustomerBuys2_InvoiceHasTwoItems_OnlyOneItemForSaleLeft() throws BuisnessLogicException {
        var customerNumber = "1A35";

        var customer = new CustomerDto();
        customer.setFirstName("Markus");
        customer.setLastName("Schwarz");
        customer.setCustomerNumber(customerNumber);
        customerLogic.insert(customer);

        var title = "Was will Putin?";

        var bookDto = new BookDto();
        bookDto.setTitle(title);
        bookDto.setBorrowing(3);
        bookDto.setFreehandArea(0);
        bookDto.setTranslation(false);
        bookLogic.insert(bookDto);

        singlePhysicalMediaLogic.setForSale(title, 2);
        customerLogic.rentBook(customerNumber, title);
        Assertions.assertThrows(BuisnessLogicException.class, () -> {
            customerLogic.rentBook(customerNumber, title);
        });
    }

    @Test
    @Transactional
    public void count()
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

        var title1 = "Was will Putin?1";
        var title2 = "Was will Putin?2";
        var title3 = "Was will Putin?3";

        var bookDto1 = new BookDto();
        bookDto1.getAuthorIds().add(findAuthor.getId());
        bookDto1.getAuthorIds().add(findAuthor2.getId());
        bookDto1.getAuthorIds().add(findAuthor3.getId());

        bookDto1.setTitle(title1);
        bookDto1.setBorrowing(5);
        bookDto1.setFreehandArea(5);
        bookDto1.setTranslation(false);
        bookLogic.insert(bookDto1);
        bookLogic.flushAndClear();

        var bookDto2 = new BookDto();
        bookDto2.getAuthorIds().add(findAuthor.getId());
        bookDto2.getAuthorIds().add(findAuthor2.getId());
        bookDto2.getAuthorIds().add(findAuthor3.getId());

        bookDto2.setTitle(title2);
        bookDto2.setBorrowing(5);
        bookDto2.setFreehandArea(5);
        bookDto2.setTranslation(false);
        bookLogic.insert(bookDto2);
        bookLogic.flushAndClear();

        var bookDto3 = new BookDto();
        bookDto3.getAuthorIds().add(findAuthor.getId());
        bookDto3.getAuthorIds().add(findAuthor2.getId());
        bookDto3.getAuthorIds().add(findAuthor3.getId());

        bookDto3.setTitle(title3);
        bookDto3.setBorrowing(5);
        bookDto3.setFreehandArea(5);
        bookDto3.setTranslation(false);
        bookLogic.insert(bookDto3);
        bookLogic.flushAndClear();


    }
    public AuthorDto createAuthor(){
        String firstname = "Robert";
        String lastname = "Lenz";

        var authorDto = new AuthorDto();
        authorDto.setFirstname(firstname);
        authorDto.setLastname(lastname);
        authorLogic.insert(authorDto);
        authorLogic.flushAndClear();
        return authorLogic.getByName(firstname, lastname);
    }
    public MediaDto createBook(){
        var title = "Was will Putin?";
        var bookDto = new MediaDto();
        bookDto.setTitle(title);
        bookDto.setTranslation(false);
        mediaLogic.insert(bookDto);
        mediaLogic.flushAndClear();

        return mediaLogic.getByName(title);
    }
    public PublisherDto createPublication(){
        var bookDto = new PublisherDto();
        bookDto.setName("MEINS");
        return bookDto;
    }

    //XML ERZEUGEN
    @Test
    public void createWorksOfAuthorDTO_serializeToXml_deserialize_checkObjects() throws BuisnessLogicException {
        var author = createAuthor();
        var target = new WorksOfAuthorDto();
        target.setAuthor(author);
        var media = createBook();
        target.getWork().add(media);
        target.getPublication().add(createPublication());

        authorLogic.createXML(target);
    }
}