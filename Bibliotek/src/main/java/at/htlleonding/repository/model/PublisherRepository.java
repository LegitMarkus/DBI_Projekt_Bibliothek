package at.htlleonding.repository.model;

import at.htlleonding.persistence.AudioBook;
import at.htlleonding.persistence.Publisher;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class PublisherRepository {
    @Inject
    EntityManager em;

    @Transactional
    public List<Publisher> loadAll() {
        return em.createQuery("select x from Publisher x", Publisher.class).getResultList();
    }
    @Transactional
    public Publisher findById(Integer id){
        return em.createQuery("select x from Publisher x where x.id = :id", Publisher.class).setParameter("id", id).getSingleResult();
    }
}
