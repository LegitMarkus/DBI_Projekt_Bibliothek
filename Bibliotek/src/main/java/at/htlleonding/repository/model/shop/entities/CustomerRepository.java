package at.htlleonding.repository.model.shop.entities;

import at.htlleonding.persistence.shop.entities.Customer;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class CustomerRepository {
    @Inject
    EntityManager em;

    @Transactional
    public List<Customer> loadAll() {
        return em.createQuery("select x from Customer x", Customer.class).getResultList();
    }
    @Transactional
    public Customer findById(Integer id){
        return em.createQuery("select x from Customer x where x.id = :id", Customer.class).setParameter("id", id).getSingleResult();
    }
    @Transactional
    public Customer findByCustommerNumber(String title){
        return em.createQuery("select x from Customer x where x.customerNumber = :title", Customer.class)
                .setParameter("title", title).getSingleResult();
    }
}
