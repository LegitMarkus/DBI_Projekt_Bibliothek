package at.htlleonding.repository.model;

import at.htlleonding.persistence.AudioBook;
import at.htlleonding.persistence.PhysicalMedia;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class PhysicalMediaRepository {
    @Inject
    EntityManager em;

    @Transactional
    public List<PhysicalMedia> loadAll() {
        return em.createQuery("select x from PhysicalMedia x", PhysicalMedia.class).getResultList();
    }
    @Transactional
    public PhysicalMedia findById(Integer id){
        return em.createQuery("select x from PhysicalMedia x where x.id = :id", PhysicalMedia.class).setParameter("id", id).getSingleResult();
    }
}
