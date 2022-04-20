package at.htlleonding.repository;

import at.htlleonding.persistence.*;
import at.htlleonding.persistence.shop.entities.*;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
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

    @Transactional
    public void add(Author author){
        em.persist(author);}
    @Transactional
    public void add(Book book){
        em.persist(book);}
    @Transactional
    public void add(DigitalMedia digitalMedia){
        em.persist(digitalMedia);}
    @Transactional
    public void add(EBook eBook){
        em.persist(eBook);}
    @Transactional
    public void add(Genre genre){
        em.persist(genre);}
    @Transactional
    public void add(AudioBook audioBook){
        em.persist(audioBook);}
    @Transactional
    public void add(Media media){
        em.persist(media);}
    @Transactional
    public void add(PhysicalMedia physicalMedia){
        em.persist(physicalMedia);}
    @Transactional
    public void add(Language language){
        em.persist(language);}
    @Transactional
    public void add(Speaker speaker){
        em.persist(speaker);}
    @Transactional
    public void add(Topic topic){
        em.persist(topic);}
    @Transactional
    public void add(Publisher publisher){
        em.persist(publisher);}
    @Transactional
    public void add(Magazine magazine){
        em.persist(magazine);}
    @Transactional
    public void add(Newspaper newspaper){
        em.persist(newspaper);}

    @Transactional
    public void add(Author a, Media m){
        if (a.getId() == null)
            add(a);
        if (m.getId() == null)
            add(m);

        m.getAuthors().add(a);
        a.getMedias().add(m);

        em.persist(m);
        em.persist(a);
    }
    @Transactional
    public void add(Media m, Author a){
        add(a, m);
    }

    @Transactional
    public void add(Media m, Genre g){
        if (m.getId() == null)
            add(m);
        if (g.getId() == null)
            add(g);

        g.getMedias().add(m);
        m.setGenre(g);

        em.persist(g);
        em.persist(m);
    }
    @Transactional
    public void add(Genre g, Media m){
        add(m, g);
    }

    @Transactional
    public void add(AudioBook h, Speaker s){
        if (h.getId() == null)
            add(h);
        if (s.getId() == null)
            add(s);

        s.getAudioBooks().add(h);
        h.getSpeakers().add(s);

        em.persist(s);
        em.persist(h);
    }
    @Transactional
    public void add(Speaker s, AudioBook h){
        add(h, s);
    }

    @Transactional
    public void add(Media m, Publisher v){
        if (m.getId() == null)
            add(m);
        if (v.getId() == null)
            add(v);

        v.getMedias().add(m);
        m.setPublisher(v);

        em.persist(v);
        em.persist(m);
    }
    @Transactional
    public void add(Publisher v, Media m){
        add(m ,v);
    }

    @Transactional
    public void add(Media m, Language s){
        if (m.getId() == null)
            add(m);
        if (s.getId() == null)
            add(s);

        s.getMedias().add(m);
        m.setLanguage(s);

        em.persist(s);
        em.persist(m);
    }
    @Transactional
    public void add(Language s, Media m){
        add(m, s);
    }

    @Transactional
    public void add(Media m, Topic t){
        if (m.getId() == null)
            add(m);
        if (t.getId() == null)
            add(t);

        t.getMedias().add(m);
        m.getTopics().add(t);

        em.persist(t);
        em.persist(m);
    }
    @Transactional
    public void add(Topic t, Media m){
        add(m, t);
    }

    @Transactional
    public void add(SinglePhysicalMedia singlePhysicalMedia, Customer customer, Date lendingDate, Date returnDate) {
        if(singlePhysicalMedia.getId() == null) {
            add(singlePhysicalMedia);
        }
        if(customer.getId() == null) {
            add(customer);
        }
        var assoc = new Lendings(singlePhysicalMedia, customer, lendingDate, returnDate);
        singlePhysicalMedia.getLendings().add(assoc);
        customer.getLendings().add(assoc);

        em.persist(assoc);
        em.persist(singlePhysicalMedia);
        em.persist(customer);
    }
    @Transactional
    public void add(SinglePhysicalMedia singlePhysicalMedia, Customer customer, Date reservationDate) {
        if(singlePhysicalMedia.getId() == null) {
            add(singlePhysicalMedia);
        }
        if(customer.getId() == null) {
            add(customer);
        }
        var assoc = new Reservation(singlePhysicalMedia, customer, reservationDate);
        singlePhysicalMedia.getReservations().add(assoc);
        customer.getReservations().add(assoc);

        em.persist(assoc);
        em.persist(singlePhysicalMedia);
        em.persist(customer);
    }
    @Transactional
    public void add(SinglePhysicalMedia singlePhysicalMedia, Customer customer, Integer price) {
        if(singlePhysicalMedia.getId() == null) {
            add(singlePhysicalMedia);
        }
        if(customer.getId() == null) {
            add(customer);
        }
        var assoc = new Bill(singlePhysicalMedia, customer, price);
        singlePhysicalMedia.getBills().add(assoc);
        customer.getBills().add(assoc);

        em.persist(assoc);
        em.persist(singlePhysicalMedia);
        em.persist(customer);
    }

    @Transactional
    public void add(SinglePhysicalMedia singlePhysicalMedia, PhysicalMedia physicalMedia){
        if (singlePhysicalMedia.getId() == null)
            add(singlePhysicalMedia);
        if (physicalMedia.getId() == null)
            add(physicalMedia);

        physicalMedia.getSinglePhysicalMediaSet().add(singlePhysicalMedia);
        singlePhysicalMedia.setPhysicalMedia(physicalMedia);

        em.persist(physicalMedia);
        em.persist(singlePhysicalMedia);
    }


}
