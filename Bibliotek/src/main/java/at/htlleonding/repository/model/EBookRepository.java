package at.htlleonding.repository.model;

import at.htlleonding.persistence.AudioBook;
import at.htlleonding.persistence.EBook;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class EBookRepository {
    @Inject
    EntityManager em;

    @Transactional
    public List<EBook> loadAll() {
        return em.createQuery("select x from EBook x", EBook.class).getResultList();
    }
    @Transactional
    public EBook findById(Integer id){
        return em.createQuery("select x from EBook x where x.id = :id", EBook.class).setParameter("id", id).getSingleResult();
    }
}
