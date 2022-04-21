package at.htlleonding.repository.model.shop.entities;

import at.htlleonding.persistence.shop.entities.Lending;
import at.htlleonding.persistence.shop.entities.Reservation;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ReservationRepository {
    @Inject
    EntityManager em;

    @Transactional
    public List<Reservation> loadAll() {
        return em.createQuery("select x from Reservation x", Reservation.class).getResultList();
    }
    @Transactional
    public Reservation findById(Integer id){
        return em.createQuery("select x from Reservation x where x.id = :id", Reservation.class).setParameter("id", id).getSingleResult();
    }
}
