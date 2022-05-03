package at.htlleonding.repository.model;

import at.htlleonding.persistence.AudioBook;
import at.htlleonding.persistence.DigitalMedia;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class DigitalMediaRepository {
    @Inject
    EntityManager em;

    @Transactional
    public List<DigitalMedia> loadAll() {
        return em.createQuery("select x from DigitalMedia x", DigitalMedia.class).getResultList();
    }
    @Transactional
    public DigitalMedia findById(Integer id){
        return em.createQuery("select x from DigitalMedia x where x.id = :id", DigitalMedia.class).setParameter("id", id).getSingleResult();
    }
}
