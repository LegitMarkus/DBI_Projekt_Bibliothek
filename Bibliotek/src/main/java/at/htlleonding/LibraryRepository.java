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
    public void add(Digitale_Medien digitaleMedien){
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

    public void add(Author a, Digitale_Medien dm){
        if (a.getId() == null)
            add(a);
        if (dm.getId() == null)
            add(dm);

        dm.getAuthors().add(a);
        a.getDigitaleMedien().add(dm);

        em.persist(dm);
        em.persist(a);
    }

    public void add(Author a, Buch b){
        if (a.getId() == null)
            add(a);
        if (b.getId() == null)
            add(b);

        b.getAuthors().add(a);
        a.getBucher().add(b);

        em.persist(b);
        em.persist(a);
    }

    public void add(Buch b, Genre g){
        if (b.getId() == null)
            add(b);
        if (g.getId() == null)
            add(g);

        g.getBuecher().add(b);
        b.setGenre(g);

        em.persist(g);
        em.persist(b);
    }
    public void add(Digitale_Medien dm, Genre g){
        if (dm.getId() == null)
            add(dm);
        if (g.getId() == null)
            add(g);

        g.getDigitale_mediens().add(dm);
        dm.setGenre(g);

        em.persist(g);
        em.persist(dm);
    }
    public void add(Hoerbuch h, Sprecher s){
        if (h.getId() == null)
            add(h);
        if (s.getId() == null)
            add(s);

        s.getHoerbucher().add(h);
        h.getSprechers().add(s);

        em.persist(s);
        em.persist(h);
    }
    public void add(Medien m, Verlag v){
        if (m.getId() == null)
            add(m);
        if (v.getId() == null)
            add(v);

        v.getMedien().add(m);
        m.setVerlag(v);

        em.persist(v);
        em.persist(m);
    }
    public void add(Medien m, Sprache s){
        if (m.getId() == null)
            add(m);
        if (s.getId() == null)
            add(s);

        s.getMedien().add(m);
        m.setSprache(s);

        em.persist(s);
        em.persist(m);
    }
    public void add(Medien m, Topic t){
        if (m.getId() == null)
            add(m);
        if (t.getId() == null)
            add(t);

        t.getMedien().add(m);
        m.getTopics().add(t);

        em.persist(t);
        em.persist(m);
    }

}
