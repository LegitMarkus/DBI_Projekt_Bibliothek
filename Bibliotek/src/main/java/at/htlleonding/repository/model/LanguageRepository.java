package at.htlleonding.repository.model;

import at.htlleonding.persistence.AudioBook;
import at.htlleonding.persistence.Language;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class LanguageRepository {
    @Inject
    EntityManager em;

    @Transactional
    public List<Language> loadAll() {
        return em.createQuery("select x from Language x", Language.class).getResultList();
    }
    @Transactional
    public Language findById(Integer id){
        return em.createQuery("select x from Language x where x.id = :id", Language.class).setParameter("id", id).getSingleResult();
    }
}
