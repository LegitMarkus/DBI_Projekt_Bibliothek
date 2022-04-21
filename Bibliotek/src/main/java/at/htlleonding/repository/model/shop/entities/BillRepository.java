package at.htlleonding.repository.model.shop.entities;

import at.htlleonding.persistence.shop.entities.Bill;
import at.htlleonding.persistence.shop.entities.BillKey;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class BillRepository {
    @Inject
    EntityManager em;

    @Transactional
    public List<Bill> loadAll() {
        return em.createQuery("select x from Bill x", Bill.class).getResultList();
    }
    @Transactional
    public Bill findById(BillKey id){
        return em.createQuery("select x from Bill x where x.id = :id", Bill.class).setParameter("id", id).getSingleResult();
    }
}
