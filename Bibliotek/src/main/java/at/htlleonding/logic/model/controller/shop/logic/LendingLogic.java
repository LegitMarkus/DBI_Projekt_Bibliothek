package at.htlleonding.logic.model.controller.shop.logic;

import at.htlleonding.dto.shop.entities.LendingDto;
import at.htlleonding.logic.LibraryMgmtLogic;
import at.htlleonding.logic.model.controller.BookLogic;
import at.htlleonding.logic.model.controller.BuisnessLogicException;
import at.htlleonding.logic.model.controller.PhysicalMediaLogic;
import at.htlleonding.mapper.model.PhysicalMediaMappingHelper;
import at.htlleonding.mapper.model.shop.entities.LendingMappingHelper;
import at.htlleonding.repository.model.shop.entities.LendingRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class LendingLogic extends LibraryMgmtLogic {

    @Inject
    LendingRepository lendingRepository;
    @Inject
    LendingMappingHelper mappingHelper;

    public void insert(LendingDto dto){
        var entity =  mappingHelper.fromDto(dto);
        crudOperations.add(entity);
    }
    public void update(LendingDto dto){
        var entity =  mappingHelper.fromDto(dto);
        crudOperations.update(entity);
    }
    public LendingDto getById(Integer id){
        var entity = lendingRepository.findById(id);
        return mappingHelper.toDto(entity);
    }
    @Inject
    PhysicalMediaLogic physicalMediaLogic;
    @Inject
    PhysicalMediaMappingHelper physicalMediaMappingHelper;
    @Inject
    BookLogic bookLogic;
    public void returnBook(LendingDto lendingDto) {
        // Media (Book) wird aus der DB abgeholt
        var mediaDto = bookLogic.getById(lendingDto.getMediaId());
        // ist zurückgebracht! (Wir speichern alle LendingDTOs)
        lendingDto.setReturned(true);

        // zu faul um in der lendingDTO update() zu implementieren
        var lending = mappingHelper.fromDto(lendingDto);
        crudOperations.update(lending);
        //lendingDto.update(lendingDto);

        // anzahl Bücher zum ausleihen um 1 erhöhen!
        mediaDto.setBorrowing(mediaDto.getBorrowing() + 1);
        // MediaDTO (BOOK) wird aktualisiert
        bookLogic.update(mediaDto);
    }
    @Inject
    CustomerLogic customerLogic;
    public void prolongRentedItemCustomer(LendingDto lending) throws BuisnessLogicException {
        if(lending.getExtension()>=2){
            throw new BuisnessLogicException("customer can only prolong 2 timens");
        }
        prolongRentedItemEmpl(lending);
        lending.setExtension(lending.getExtension() + 1);
        lending.setReturnDate(add2Weeks(lending.getReturnDate()));
        update(lending);
    }
    public void prolongRentedItemEmpl(LendingDto lending) throws BuisnessLogicException {
        if(lending.getExtension()>=3){
            throw new BuisnessLogicException("employee can only prolong 3 timens");
        }
        lending.setExtension(lending.getExtension() + 1);
        lending.setReturnDate(add2Weeks(lending.getReturnDate()));
        update(lending);
    }
}
