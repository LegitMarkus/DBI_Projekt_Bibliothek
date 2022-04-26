package at.htlleonding.logic.model.controller;

import at.htlleonding.dto.NewspaperDto;
import at.htlleonding.dto.SinglePhysicalMediaDto;
import at.htlleonding.logic.LibraryMgmtLogic;
import at.htlleonding.mapper.model.NewspaperMappingHelper;
import at.htlleonding.mapper.model.SinglePhysicalMediaMappingHelper;
import at.htlleonding.repository.model.SinglePhysicalMediaRepository;

import javax.inject.Inject;

public class SinglePhysicalMediaLogic extends LibraryMgmtLogic {

    @Inject
    SinglePhysicalMediaRepository singlePhysicalMediaRepository;
    @Inject
    SinglePhysicalMediaMappingHelper mappingHelper;

    public void insert(SinglePhysicalMediaDto dto){
        var entity =  mappingHelper.fromDto(dto);
        crudOperations.add(entity);
    }
    public SinglePhysicalMediaDto getById(int id){
        var entity = singlePhysicalMediaRepository.findById(id);
        return mappingHelper.toDto(entity);
    }
}
