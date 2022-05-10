package at.htlleonding.repository.model;

import at.htlleonding.persistence.AudioBook;
import at.htlleonding.persistence.Newspaper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class AudioBookRepository {
    @Inject
    EntityManager em;

    @Transactional
    public List<AudioBook> loadAll() {
        return em.createQuery("select x from AudioBook x", AudioBook.class).getResultList();
    }
    @Transactional
    public AudioBook findById(Integer id){
        return em.createQuery("select x from AudioBook x where x.id = :id", AudioBook.class).setParameter("id", id).getSingleResult();
    }
    @Transactional
    public AudioBook findByName(String title){
        return em.createQuery("select x from AudioBook x where x.title = :title", AudioBook.class)
                .setParameter("title", title).getSingleResult();
    }
}
