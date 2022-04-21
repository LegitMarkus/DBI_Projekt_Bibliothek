package at.htlleonding.repository.model;

import at.htlleonding.persistence.AudioBook;
import at.htlleonding.persistence.Genre;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class GenreRepository {
    @Inject
    EntityManager em;

    @Transactional
    public List<Genre> loadAll() {
        return em.createQuery("select x from Genre x", Genre.class).getResultList();
    }
    @Transactional
    public Genre findById(Integer id){
        return em.createQuery("select x from Genre x where x.id = :id", Genre.class).setParameter("id", id).getSingleResult();
    }
}
