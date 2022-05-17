package at.htlleonding.logic.model.controller.shop.logic;

import at.htlleonding.dto.shop.entities.CustomerDto;
import at.htlleonding.dto.shop.entities.LendingDto;
import at.htlleonding.logic.LibraryMgmtLogic;
import at.htlleonding.logic.model.controller.*;
import at.htlleonding.mapper.model.shop.entities.CustomerMappingHelper;
import at.htlleonding.repository.model.shop.entities.CustomerRepository;
import net.bytebuddy.implementation.bytecode.Throw;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

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
    public void rentBook(String customerNumber, String title){
        var customerDatabase = getByCustommerNumber(customerNumber);
        var book = bookLogic.getByName(title);
        if (book.getBorrowing() <= 0){
            try {
                throw new Exception("No books are available for rent!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        var lending = new LendingDto();
        lending.setCustommerId(customerDatabase.getId());
        lending.setMediaId(book.getId());
        book.setBorrowing(book.getBorrowing() - 1);

        bookLogic.update(book);
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