package at.htlleonding.repository.model;

import at.htlleonding.persistence.AudioBook;
import at.htlleonding.persistence.SinglePhysicalMedia;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class SinglePhysicalMediaRepository {
    @Inject
    EntityManager em;

    @Transactional
    public List<SinglePhysicalMedia> loadAll() {
        return em.createQuery("select x from SinglePhysicalMedia x", SinglePhysicalMedia.class).getResultList();
    }
    @Transactional
    public SinglePhysicalMedia findById(Integer id){
        return em.createQuery("select x from SinglePhysicalMedia x where x.id = :id", SinglePhysicalMedia.class).setParameter("id", id).getSingleResult();
    }
}
