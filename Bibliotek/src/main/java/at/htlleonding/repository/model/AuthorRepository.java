package at.htlleonding.repository.model;

import at.htlleonding.persistence.AudioBook;
import at.htlleonding.persistence.Author;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class AuthorRepository {
    @Inject
    EntityManager em;

    @Transactional
    public List<Author> loadAll() {
        return em.createQuery("select x from Author x", Author.class).getResultList();
    }
    @Transactional
    public Author findById(Integer id){
        return em.createQuery("select x from Author x where x.id = :id", Author.class).setParameter("id", id).getSingleResult();
    }
}
