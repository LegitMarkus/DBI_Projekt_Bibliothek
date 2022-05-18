package at.htlleonding.repository.model.shop.entities;

import at.htlleonding.logic.model.controller.BuisnessLogicException;
import at.htlleonding.logic.model.controller.shop.logic.CustomerLogic;
import at.htlleonding.persistence.AudioBook;
import at.htlleonding.persistence.shop.entities.Customer;
import at.htlleonding.persistence.shop.entities.Lending;
import at.htlleonding.persistence.shop.entities.LendingKey;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class LendingRepository {
    @Inject
    EntityManager em;

    @Transactional
    public List<Lending> loadAll() {
        return em.createQuery("select x from Lending x", Lending.class).getResultList();
    }
    @Transactional
    public Lending findById(Integer id){
        return em.createQuery("select x from Lending x where x.id = :id", Lending.class).setParameter("id", id).getSingleResult();
    }
}
