package at.htlleonding;

import at.htlleonding.persistence.*;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.awt.print.Book;

public class LibraryRepository {
    @Inject
    EntityManager em;

    public void add(Author author){
        em.persist(author);}
    public void add(Book book){
        em.persist(book);}
    public void add(DigitaleMedien digitaleMedien){
        em.persist(digitaleMedien);}
    public void add(EBook eBook){
        em.persist(eBook);}
    public void add(Genre genre){
        em.persist(genre);}
    public void add(Hoerbuch hoerbuch){
        em.persist(hoerbuch);}
    public void add(Medien medien){
        em.persist(medien);}
    public void add(Physische_Medien physischeMedien){
        em.persist(physischeMedien);}
    public void add(Sprache sprache){
        em.persist(sprache);}
    public void add(Sprecher sprecher){
        em.persist(sprecher);}
    public void add(Topic topic){
        em.persist(topic);}
    public void add(Verlag verlag){
        em.persist(verlag);}
    public void add(Zeitschrift zeitschrift){
        em.persist(zeitschrift);}
    public void add(Zeitung zeitung){
        em.persist(zeitung);}

}
