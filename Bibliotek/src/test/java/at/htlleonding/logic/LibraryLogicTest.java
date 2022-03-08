package at.htlleonding.logic;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class LibraryLogicTest {

    @Inject
    LibraryLogic target;

    private final String[][] authors = {
            new String[] {"Manfred", "Spitzer", "27.05.1958", ""},
            new String[] {"George", "Orwell", "25.06.1903", "21.01.1950"},
            new String[] {"Winston", "Smith", "25.06.1903", "21.01.1945"}
    };

    private final String[][] books = {
            new String[]{"Spitzer", "Lernen", "Nonfiction"},
            new String[]{"Spitzer", "Musik im Kopf", "Nonfiction"},
            new String[]{"Orwell", "1984", "Fiction", "Smith"},
            new String[]{"Orwell", "Animal Farm", "Fiction"}
    };

    private final String[][] topics = {
            new String[]{"Spitzer", "Lernen", "Lernpsychologie", "Psychologie", "Populärwissenschaft"},
            new String[]{"Spitzer", "Musik im Kopf", "Lernpsychologie", "Musik"},
            new String[]{"Orwell", "1984", "Dystopie", "Prophezeiung"},
            new String[]{"Orwell", "Animal Farm", "Dystopie", "Biographie"}
    };

    @TestTransaction
    @Test
    void importLibraryData_3Authors_4Books() {
        target.importLibraryData(authors, books, topics);

        var resultAuthors = target.getAuthors();
        assertNotNull(resultAuthors);
        assertEquals(3, resultAuthors.length);

        var resultBooks = target.getBooks();
        assertNotNull(resultBooks);
        assertEquals(4, resultBooks.length);
    }

    @TestTransaction
    @Test
    void importLibraryDataSecondTime_SameCounters() {
        target.importLibraryData(authors, books, topics);

        var resultAuthors = target.getAuthors();
        assertNotNull(resultAuthors);
        assertEquals(3, resultAuthors.length);

        var resultBooks = target.getBooks();
        assertNotNull(resultBooks);
        assertEquals(4, resultBooks.length);

    }
}