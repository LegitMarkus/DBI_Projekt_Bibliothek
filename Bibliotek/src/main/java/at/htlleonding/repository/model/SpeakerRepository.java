package at.htlleonding.repository.model;

import at.htlleonding.persistence.AudioBook;
import at.htlleonding.persistence.Speaker;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class SpeakerRepository {
    @Inject
    EntityManager em;

    @Transactional
    public List<Speaker> loadAll() {
        return em.createQuery("select x from Speaker x", Speaker.class).getResultList();
    }
    @Transactional
    public Speaker findById(Integer id){
        return em.createQuery("select x from Speaker x where x.id = :id", Speaker.class).setParameter("id", id).getSingleResult();
    }
}
