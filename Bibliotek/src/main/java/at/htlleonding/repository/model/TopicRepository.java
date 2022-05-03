package at.htlleonding.repository.model;

import at.htlleonding.persistence.AudioBook;
import at.htlleonding.persistence.Topic;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class TopicRepository {
    @Inject
    EntityManager em;

    @Transactional
    public List<Topic> loadAll() {
        return em.createQuery("select x from Topic x", Topic.class).getResultList();
    }
    @Transactional
    public Topic findById(Integer id){
        return em.createQuery("select x from Topic x where x.id = :id", Topic.class).setParameter("id", id).getSingleResult();
    }
}
