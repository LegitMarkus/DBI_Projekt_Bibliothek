package at.htlleonding;

import at.htlleonding.persistence.*;
import at.htlleonding.persistence.ausleih_Verkauf_Entitäten.*;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.awt.print.Book;
import java.util.Date;

@ApplicationScoped
public class LibraryRepository {
    @Inject
    EntityManager em;

    @Transactional
    public<T> void add(T entity){
        em.persist(entity);
    }

    @Transactional
    public<T> void delete(T entity){
        em.remove(entity);
    }
    //@Transactional
    //public void add(Author author){
    //    em.persist(author);}
    //@Transactional
    //public void add(Book book){
    //    em.persist(book);}
    //@Transactional
    //public void add(DigitaleMedien digitaleMedien){
    //    em.persist(digitaleMedien);}
    //@Transactional
    //public void add(EBook eBook){
    //    em.persist(eBook);}
    //@Transactional
    //public void add(Genre genre){
    //    em.persist(genre);}
    //@Transactional
    //public void add(Hoerbuch hoerbuch){
    //    em.persist(hoerbuch);}
    //@Transactional
    //public void add(Medien medien){
    //    em.persist(medien);}
    //@Transactional
    //public void add(PhysischeMedien physischeMedien){
    //    em.persist(physischeMedien);}
    //@Transactional
    //public void add(Sprache sprache){
    //    em.persist(sprache);}
    //@Transactional
    //public void add(Sprecher sprecher){
    //    em.persist(sprecher);}
    //@Transactional
    //public void add(Topic topic){
    //    em.persist(topic);}
    //@Transactional
    //public void add(Verlag verlag){
    //    em.persist(verlag);}
    //@Transactional
    //public void add(Zeitschrift zeitschrift){
    //    em.persist(zeitschrift);}
    //@Transactional
    //public void add(Zeitung zeitung){
    //    em.persist(zeitung);}

    @Transactional
    public void add(Author a, Medien m){
        if (a.getId() == null)
            add(a);
        if (m.getId() == null)
            add(m);

        m.getAuthors().add(a);
        a.getMedien().add(m);

        em.persist(m);
        em.persist(a);
    }
    @Transactional
    public void add(Medien m, Author a){
        add(a, m);
    }

    @Transactional
    public void add(Medien m, Genre g){
        if (m.getId() == null)
            add(m);
        if (g.getId() == null)
            add(g);

        g.getMedien().add(m);
        m.setGenre(g);

        em.persist(g);
        em.persist(m);
    }
    @Transactional
    public void add(Genre g, Medien m){
        add(m, g);
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
    public void add(Sprecher s, Hoerbuch h){
        add(h, s);
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
    public void add(Verlag v, Medien m){
        add(m ,v);
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
    public void add(Sprache s, Medien m){
        add(m, s);
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
    @Transactional
    public void add(Topic t, Medien m){
        add(m, t);
    }

    @Transactional
    public void add(SinglePhysicalMedium m, Kunde k, Date ausleihdatum, Date rückgabedatum) {
        if(m.getId() == null) {
            add(m);
        }
        if(k.getId() == null) {
            add(k);
        }
        var assoc = new Ausleihung(m, k, ausleihdatum, rückgabedatum);
        m.getAusleihungen().add(assoc);
        k.getAusleihungen().add(assoc);

        em.persist(assoc);
        em.persist(m);
        em.persist(k);
    }
    @Transactional
    public void add(SinglePhysicalMedium m, Kunde k, Date reservierungsdatum) {
        if(m.getId() == null) {
            add(m);
        }
        if(k.getId() == null) {
            add(k);
        }
        var assoc = new Reservierung(m, k, reservierungsdatum);
        m.getReservierungen().add(assoc);
        k.getReservierungen().add(assoc);

        em.persist(assoc);
        em.persist(m);
        em.persist(k);
    }
    @Transactional
    public void add(SinglePhysicalMedium pm, Kunde k, Integer preis) {
        if(pm.getId() == null) {
            add(pm);
        }
        if(k.getId() == null) {
            add(k);
        }
        var assoc = new Rechnung(pm, k, preis);
        pm.getRechnungen().add(assoc);
        k.getRechnungen().add(assoc);

        em.persist(assoc);
        em.persist(pm);
        em.persist(k);
    }

    @Transactional
    public void add(SinglePhysicalMedium spm, PhysischeMedien pm){
        if (spm.getId() == null)
            add(spm);
        if (pm.getId() == null)
            add(pm);

        pm.getEinzelneMedien().add(spm);
        spm.setPhysischeMedien(pm);

        em.persist(pm);
        em.persist(spm);
    }
}
