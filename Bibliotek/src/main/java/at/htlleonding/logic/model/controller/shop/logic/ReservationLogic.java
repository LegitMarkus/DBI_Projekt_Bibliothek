package at.htlleonding.logic.model.controller.shop.logic;

import at.htlleonding.dto.NewspaperDto;
import at.htlleonding.dto.shop.entities.LendingDto;
import at.htlleonding.dto.shop.entities.ReservationDto;
import at.htlleonding.logic.LibraryMgmtLogic;
import at.htlleonding.logic.model.controller.BookLogic;
import at.htlleonding.logic.model.controller.BuisnessLogicException;
import at.htlleonding.mapper.model.BookMappingHelper;
import at.htlleonding.mapper.model.NewspaperMappingHelper;
import at.htlleonding.mapper.model.shop.entities.ReservationMappingHelper;
import at.htlleonding.persistence.Book;
import at.htlleonding.persistence.SinglePhysicalMedia;
import at.htlleonding.persistence.shop.entities.Lending;
import at.htlleonding.persistence.shop.entities.Reservation;
import at.htlleonding.persistence.shop.entities.ReservationKey;
import at.htlleonding.repository.model.NewspaperRepository;
import at.htlleonding.repository.model.shop.entities.ReservationRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Date;
import java.util.List;
import java.util.Set;

@ApplicationScoped
public class ReservationLogic extends LibraryMgmtLogic {

    @Inject
    ReservationRepository newspaperRepository;
    @Inject
    ReservationMappingHelper mappingHelper;

    public void insert(ReservationDto dto){
        var entity =  mappingHelper.fromDto(dto);
        crudOperations.add(entity);
    }
    public ReservationDto getById(Integer id){
        var entity = newspaperRepository.findById(id);
        return mappingHelper.toDto(entity);
    }
    public List<Reservation> loadAll(){
        return newspaperRepository.loadAll();
    }

    @Inject CustomerLogic customerLogic;
    @Inject
    BookLogic bookLogic;
    @Inject
    ReservationLogic reservationLogic;
    public void reserveBook(String customerNumber, String title) {
        // die Daten mit queries abholen
        var customerDatabase = customerLogic.getByCustommerNumber(customerNumber);
        var bookDto = bookLogic.getByName(title);

        // Neue Reservierung erstellen!
        var reservation = new ReservationDto();
        reservation.setReservationDate(new Date());
        reservation.setMediaId(bookDto.getId());
        reservation.setCustomerId(customerDatabase.getId());

        // Reservierung in der DB inserten
        reservationLogic.insert(reservation);
    }

}
