package at.htlleonding.repository.model;

import at.htlleonding.persistence.AudioBook;
import at.htlleonding.persistence.Media;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class MediaRepository {
    @Inject
    EntityManager em;

    @Transactional
    public List<Media> loadAll() {
        return em.createQuery("select x from Media x", Media.class).getResultList();
    }
    @Transactional
    public Media findById(Integer id){
        return em.createQuery("select x from Media x where x.id = :id", Media.class).setParameter("id", id).getSingleResult();
    }
}
