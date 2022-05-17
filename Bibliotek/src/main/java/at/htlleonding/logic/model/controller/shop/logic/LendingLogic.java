package at.htlleonding.logic.model.controller.shop.logic;

import at.htlleonding.dto.NewspaperDto;
import at.htlleonding.dto.shop.entities.LendingDto;
import at.htlleonding.logic.LibraryMgmtLogic;
import at.htlleonding.logic.model.controller.BookLogic;
import at.htlleonding.logic.model.controller.BuisnessLogicException;
import at.htlleonding.logic.model.controller.PhysicalMediaLogic;
import at.htlleonding.mapper.model.NewspaperMappingHelper;
import at.htlleonding.mapper.model.PhysicalMediaMappingHelper;
import at.htlleonding.mapper.model.shop.entities.LendingMappingHelper;
import at.htlleonding.persistence.shop.entities.Lending;
import at.htlleonding.persistence.shop.entities.LendingKey;
import at.htlleonding.repository.model.shop.entities.CustomerRepository;
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
        var mediaDto = bookLogic.getById(lendingDto.getMediaId());

        lendingDto.setReturned(true);

        var lending = mappingHelper.fromDto(lendingDto);
        crudOperations.update(lending);

        mediaDto.setBorrowing(mediaDto.getBorrowing() + 1);
        //var media = physicalMediaMappingHelper.fromDto(mediaDto);
        bookLogic.update(mediaDto);
        //crudOperations.update(media);
    }
}
