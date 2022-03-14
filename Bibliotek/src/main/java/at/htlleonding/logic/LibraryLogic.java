package at.htlleonding.logic;

import at.htlleonding.persistence.old.*;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@ApplicationScoped
public class LibraryLogic {

    @Inject
    private LibraryRepository service;

    @Transactional
    public void importLibraryData(String[][] authorData, String[][] bookData, String[][] topicData) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.uuuu");

        for (String[] adata : authorData) {
            Author a = service.getAuthorByLastName(adata[1]);
            if (a == null) {
                a = new Author();
                a.setFirstName(adata[0]);
                a.setLastName(adata[1]);
                a.setDateBirth(LocalDate.parse(adata[2], dtf));
                if (adata[3] != null && adata[3] != "") {
                    a.setDateDeath(LocalDate.parse(adata[3], dtf));
                }
                service.add(a);
            }
        }

        for (String[] bdata : bookData) {
            Author a = service.getAuthorByLastName(bdata[0]);
            Book b = service.getBook(bdata[0], bdata[1]);
            if (b == null) {
                b = new Book();
                b.setTitle(bdata[1]);

                service.add(b, a, true);

                Genre g = service.getGenre(bdata[2]);
                if (g == null) {
                    g = new Genre(bdata[2]);
                }
                service.add(b, g);

                for (int i = 3; i < bdata.length; i++) {
                    Author adda = service.getAuthorByLastName(bdata[i]);
                    if (adda != null)
                        service.add(b, adda, false);
                }
            }
        }

        for (String[] tdata : topicData) {
            Author a = service.getAuthorByLastName(tdata[0]);
            Book b = service.getBook(tdata[0], tdata[1]);
            for (int i = 2; i < tdata.length; i++) {
                Topic t = service.getTopic(tdata[i]);
                if (t == null) {
                    t = new Topic(tdata[i]);
                }
                service.add(b, t);
            }
        }
    }
    //TODO: Implement getAuthors query
    //returns an array of string-arrays of author-data: {"FirstName", "LastName", "dd.mm.uuuu", "" | "dd.mm.uuuu"}
    @Transactional
    public String[][] getAuthors() {
        var result = new ArrayList<String[]>();
        var dtf = DateTimeFormatter.ofPattern("dd.MM.uuuu");
        return null;
    }

    //TODO: Implement getBooks query
    //returns an array of string-arrays of book-data: {"author-last-name", "title", "genre"} (only one author is reported, preferably the primary one)
    @Transactional
    public String[][] getBooks() {
        var result = new ArrayList<String[]>();
        return null;
    }

    //TODO: Implement getBooksOfTopic query
    //returns an array of string-arrays of book-data: {"author-last-name", "title", ["topic"]+}
    // (only one author is reported, preferably the primary one)
    // one of the reported topics must be equal to the keyword argument
    @Transactional
    public String[][] getBooksOfTopic(String keyword) {
        return null;
    }

    //TODO: Implement getBooksOfGenre query
    //returns an array of string-arrays of book-data: {"author-last-name", "title", "genre"}
    // (only one author is reported, preferably the primary one)
    // the genre.keyword must be equal to the keyword argument
    @Transactional
    public String[][] getBooksOfGenre(String keyword) {
        return null;
    }

    //TODO: Implement getInventory query
    //returns an array of string-arrays of book-data: {"author-last-name", "author-first-name", "title", "genre", ["topic"]+}
    //The book-data is sorted by genre, and within the genre by author-last-name.
    // (only one author is reported, preferably the primary one)
    @Transactional
    public String[][] getInventory() {
        return null;
    }

}
