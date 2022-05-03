package at.htlleonding.repository.model;

import at.htlleonding.persistence.AudioBook;
import at.htlleonding.persistence.Author;
import at.htlleonding.persistence.Book;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class BookRepository {
    @Inject
    EntityManager em;

    @Transactional
    public List<Book> loadAll() {
        return em.createQuery("select x from Book x", Book.class).getResultList();
    }
    @Transactional
    public Book findById(Integer id){
        return em.createQuery("select x from Book x where x.id = :id", Book.class).setParameter("id", id).getSingleResult();
    }
    public Book findByName(String title){
        return em.createQuery("select x from Book x where x.title = :title", Book.class)
                .setParameter("title", title).getSingleResult();
    }
}
