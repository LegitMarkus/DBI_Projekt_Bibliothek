package at.htlleonding.logic.model.controller.shop.logic;

import at.htlleonding.dto.shop.entities.CustomerDto;
import at.htlleonding.dto.shop.entities.LendingDto;
import at.htlleonding.logic.LibraryMgmtLogic;
import at.htlleonding.logic.model.controller.*;
import at.htlleonding.mapper.model.BookMappingHelper;
import at.htlleonding.mapper.model.shop.entities.CustomerMappingHelper;
import at.htlleonding.mapper.model.shop.entities.ReservationMappingHelper;
import at.htlleonding.persistence.SinglePhysicalMedia;
import at.htlleonding.persistence.shop.entities.Lending;
import at.htlleonding.repository.model.SinglePhysicalMediaRepository;
import at.htlleonding.repository.model.shop.entities.CustomerRepository;
import at.htlleonding.repository.model.shop.entities.ReservationRepository;
import net.bytebuddy.implementation.bytecode.Throw;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Date;

@ApplicationScoped
public class CustomerLogic extends LibraryMgmtLogic {

    @Inject
    CustomerRepository customerRepository;
    @Inject
    CustomerMappingHelper mappingHelper;

    public void insert(CustomerDto dto){
        var entity =  mappingHelper.fromDto(dto);
        crudOperations.add(entity);
    }
    @Inject
    BookLogic bookLogic;
    @Inject
    LendingLogic lendingLogic;
    @Inject
    BookMappingHelper bookMappingHelper;
    @Inject ReservationLogic reservationLogic;
    @Inject
    SinglePhysicalMediaRepository singlePhysicalMediaRepository;
    public LendingDto rentBook(String customerNumber, String title) throws BuisnessLogicException {
        var lending = new LendingDto();
        // queries aufrufen (CustomerNumber & Title)
        var customerDatabase = getByCustommerNumber(customerNumber);
        var book = bookLogic.getByName(title);
        // Überfrüfung ob es genug bücher zum ausleihen gibt
        if (book.getBorrowing() <= 0){
            throw new BuisnessLogicException("No books are available for rent!");
        }
        var b = bookMappingHelper.fromDto(book);

        // Checken ob Reservierungen existieren
        var reservation = reservationLogic.loadAll(); // Alle Books aus der DB abholen
        reservation.removeIf(r -> r.getMedia().getTitle() != book.getTitle()); // Books filtern
        boolean handled = false; // Handled-Boolean ist false
        for (var r : reservation){
            if (r.getCustomer().getCustomerNumber().equals(customerNumber)) {
                handled = true; // Handled ist true, wenn eine Reservierung existiert!
            }
        }
        if (reservation.isEmpty()){
            handled = true; // Handled ist true, wenn keine Reservierung existiert!
        }
        if (!handled){ // BuisnessLogicException
            throw new BuisnessLogicException("This book has a reservation!");
        }

        // Überprüfen ob ein einzelnes book verfügbar ist
        long twoWeeks = 1209600000;
        var handledRentable = false;
        var singleList = singlePhysicalMediaRepository.loadAll();
        //var singleList = b.getSinglePhysicalMedia();
        singleList.removeIf(single -> single.getPhysicalMedia().getTitle() != title);
        //var singleList = book.getSinglePhysicalMediaIds();
        for (var single : singleList){
            if (handledRentable){
                break;
            }
            if (single.getLendable() && !single.getForSale()){
                lending.setCustommerId(customerDatabase.getId());
                lending.setExtension(0);
                lending.setReturned(false);
                Date date = new Date();
                lending.setLendingDate(date);
                date.setTime(date.getTime() + twoWeeks); // frist setzen
                lending.setReturnDate(date);
                lending.setMediaId(single.getId());
                book.setBorrowing(book.getBorrowing() - 1);
                // Lending in der DB einfügen
                lendingLogic.insert(lending);
                // Book daten updaten
                bookLogic.update(book);
                handledRentable = true;
            }
        }
        return lending;
    }

    @Inject
    NewspaperLogic newspaperLogic;
    public void rentNewspaper(String customerNumber, String title){
        var customerDatabase = getByCustommerNumber(customerNumber);
        var entity = newspaperLogic.getByName(title);
        if (entity.getBorrowing() <= 0){
            try {

                throw new Exception("No newspapers are available for rent!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        var lending = new LendingDto();
        lending.setCustommerId(customerDatabase.getId());
        lending.setMediaId(entity.getId());
        entity.setBorrowing(entity.getBorrowing() - 1);

        newspaperLogic.update(entity);
    }
    @Inject
    MagazineLogic magazineLogic;
    public void rentMagazine(String customerNumber, String title){
        var customerDatabase = getByCustommerNumber(customerNumber);
        var entity = magazineLogic.getByName(title);
        if (entity.getBorrowing() <= 0){
            try {

                throw new Exception("No magazines are available for rent!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        var lending = new LendingDto();
        lending.setCustommerId(customerDatabase.getId());
        lending.setMediaId(entity.getId());
        entity.setBorrowing(entity.getBorrowing() - 1);

        magazineLogic.update(entity);
    }
    @Inject
    EBookLogic eBookLogic;
    public void rentEBook(String customerNumber, String title){
        var customerDatabase = getByCustommerNumber(customerNumber);
        var entity = eBookLogic.getByName(title);

        var lending = new LendingDto();
        lending.setCustommerId(customerDatabase.getId());
        lending.setMediaId(entity.getId());
    }
    @Inject
    AudioBookLogic audioBookLogic;
    public void rentAudioBook(String customerNumber, String title){
        var customerDatabase = getByCustommerNumber(customerNumber);
        var entity = audioBookLogic.getByName(title);

        var lending = new LendingDto();
        lending.setCustommerId(customerDatabase.getId());
        lending.setMediaId(entity.getId());
    }

    public CustomerDto getById(int id){
        var entity = customerRepository.findById(id);
        return mappingHelper.toDto(entity);
    }
    public CustomerDto getByCustommerNumber(String custommerNumber){
        var entity = customerRepository.findByCustommerNumber(custommerNumber);
        return mappingHelper.toDto(entity);
    }
}