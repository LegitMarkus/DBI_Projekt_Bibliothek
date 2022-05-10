package at.htlleonding.logic.model.controller;

import at.htlleonding.dto.NewspaperDto;
import at.htlleonding.dto.PhysicalMediaDto;
import at.htlleonding.logic.LibraryMgmtLogic;
import at.htlleonding.mapper.model.NewspaperMappingHelper;
import at.htlleonding.mapper.model.PhysicalMediaMappingHelper;
import at.htlleonding.repository.model.PhysicalMediaRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class PhysicalMediaLogic extends LibraryMgmtLogic {

    @Inject
    PhysicalMediaRepository physicalMediaRepository;
    @Inject
    PhysicalMediaMappingHelper mappingHelper;

    public void insert(PhysicalMediaDto dto){
        var entity =  mappingHelper.fromDto(dto);
        crudOperations.add(entity);
    }
    public PhysicalMediaDto getById(int id){
        var entity = physicalMediaRepository.findById(id);
        return mappingHelper.toDto(entity);
    }
}
