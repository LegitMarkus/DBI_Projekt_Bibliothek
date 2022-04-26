package at.htlleonding.logic.model.controller.shop.logic;

import at.htlleonding.dto.NewspaperDto;
import at.htlleonding.dto.shop.entities.LendingDto;
import at.htlleonding.logic.LibraryMgmtLogic;
import at.htlleonding.mapper.model.NewspaperMappingHelper;
import at.htlleonding.mapper.model.shop.entities.LendingMappingHelper;
import at.htlleonding.persistence.shop.entities.LendingKey;
import at.htlleonding.repository.model.shop.entities.LendingRepository;

import javax.inject.Inject;

public class LendingLogic extends LibraryMgmtLogic {

    @Inject
    LendingRepository lendingRepository;
    @Inject
    LendingMappingHelper mappingHelper;

    public void insert(LendingDto dto){
        var entity =  mappingHelper.fromDto(dto);
        crudOperations.add(entity);
    }
    public LendingDto getById(LendingKey id){
        var entity = lendingRepository.findById(id);
        return mappingHelper.toDto(entity);
    }
}
