package at.htlleonding.repository.model;

import at.htlleonding.persistence.AudioBook;
import at.htlleonding.persistence.Magazine;
import at.htlleonding.persistence.Newspaper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class MagazineRepository {
    @Inject
    EntityManager em;

    @Transactional
    public List<Magazine> loadAll() {
        return em.createQuery("select x from Magazine x", Magazine.class).getResultList();
    }
    @Transactional
    public Magazine findById(Integer id){
        return em.createQuery("select x from Magazine x where x.id = :id", Magazine.class).setParameter("id", id).getSingleResult();
    }
    @Transactional
    public Magazine findByName(String title){
        return em.createQuery("select x from Magazine x where x.title = :title", Magazine.class)
                .setParameter("title", title).getSingleResult();
    }
}
