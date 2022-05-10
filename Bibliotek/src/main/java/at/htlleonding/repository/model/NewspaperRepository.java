package at.htlleonding.repository.model;

import at.htlleonding.persistence.AudioBook;
import at.htlleonding.persistence.Book;
import at.htlleonding.persistence.Newspaper;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.New;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class NewspaperRepository {
    @Inject
    EntityManager em;

    @Transactional
    public List<Newspaper> loadAll() {
        return em.createQuery("select x from Newspaper x", Newspaper.class).getResultList();
    }
    @Transactional
    public Newspaper findById(Integer id){
        return em.createQuery("select x from Newspaper x where x.id = :id", Newspaper.class).setParameter("id", id).getSingleResult();
    }
    @Transactional
    public Newspaper findByName(String title){
        return em.createQuery("select x from Newspaper x where x.title = :title", Newspaper.class)
                .setParameter("title", title).getSingleResult();
    }
}
