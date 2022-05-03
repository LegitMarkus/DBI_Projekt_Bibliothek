package at.htlleonding.repository.model.shop.entities;

import at.htlleonding.persistence.shop.entities.Lending;
import at.htlleonding.persistence.shop.entities.Staff;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class StaffRepository {
    @Inject
    EntityManager em;

    @Transactional
    public List<Staff> loadAll() {
        return em.createQuery("select x from Staff x", Staff.class).getResultList();
    }
    @Transactional
    public Staff findById(Integer id){
        return em.createQuery("select x from Staff x where x.id = :id", Staff.class).setParameter("id", id).getSingleResult();
    }
}
