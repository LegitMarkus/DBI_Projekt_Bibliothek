package at.htlleonding;

import at.htlleonding.persistence.*;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.awt.print.Book;

public class LibraryRepository {
    @Inject
    EntityManager em;

    @Transactional
    public void add(Author author){
        em.persist(author);}
    @Transactional
    public void add(Book book){
        em.persist(book);}
    @Transactional
    public void add(DigitaleMedien digitaleMedien){
        em.persist(digitaleMedien);}
    @Transactional
    public void add(EBook eBook){
        em.persist(eBook);}
    @Transactional
    public void add(Genre genre){
        em.persist(genre);}
    @Transactional
    public void add(Hoerbuch hoerbuch){
        em.persist(hoerbuch);}
    @Transactional
    public void add(Medien medien){
        em.persist(medien);}
    @Transactional
    public void add(PhysischeMedien physischeMedien){
        em.persist(physischeMedien);}
    @Transactional
    public void add(Sprache sprache){
        em.persist(sprache);}
    @Transactional
    public void add(Sprecher sprecher){
        em.persist(sprecher);}
    @Transactional
    public void add(Topic topic){
        em.persist(topic);}
    @Transactional
    public void add(Verlag verlag){
        em.persist(verlag);}
    @Transactional
    public void add(Zeitschrift zeitschrift){
        em.persist(zeitschrift);}
    @Transactional
    public void add(Zeitung zeitung){
        em.persist(zeitung);}

    @Transactional
    public void add(Author a, DigitaleMedien dm){
        if (a.getId() == null)
            add(a);
        if (dm.getId() == null)
            add(dm);

        dm.getAuthors().add(a);
        a.getDigitaleMedien().add(dm);

        em.persist(dm);
        em.persist(a);
    }

    @Transactional
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

    @Transactional
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

    @Transactional
    public void add(DigitaleMedien dm, Genre g){
        if (dm.getId() == null)
            add(dm);
        if (g.getId() == null)
            add(g);

        g.getDigitale_mediens().add(dm);
        dm.setGenre(g);

        em.persist(g);
        em.persist(dm);
    }

    @Transactional
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

    @Transactional
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

    @Transactional
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

    @Transactional
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
