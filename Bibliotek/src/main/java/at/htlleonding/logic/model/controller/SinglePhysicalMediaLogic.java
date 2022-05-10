package at.htlleonding.logic.model.controller;

import at.htlleonding.dto.NewspaperDto;
import at.htlleonding.dto.SinglePhysicalMediaDto;
import at.htlleonding.logic.LibraryMgmtLogic;
import at.htlleonding.mapper.model.NewspaperMappingHelper;
import at.htlleonding.mapper.model.SinglePhysicalMediaMappingHelper;
import at.htlleonding.repository.model.PhysicalMediaRepository;
import at.htlleonding.repository.model.SinglePhysicalMediaRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class SinglePhysicalMediaLogic extends LibraryMgmtLogic {

    @Inject
    SinglePhysicalMediaRepository singlePhysicalMediaRepository;
    @Inject
    SinglePhysicalMediaMappingHelper mappingHelper;
    @Inject
    PhysicalMediaRepository physicalMediaRepository;

    public void insert(SinglePhysicalMediaDto dto){
        var entity =  mappingHelper.fromDto(dto);

        crudOperations.add(entity);
    }
    public void rent(SinglePhysicalMediaDto dto){
        var entity =  mappingHelper.fromDto(dto);
        var list = physicalMediaRepository.findById(entity.getPhysicalMedia().getId());

        list.setBorrowing(list.getBorrowing() - 1);
    }
    public void returnRented(SinglePhysicalMediaDto dto){
        var entity =  mappingHelper.fromDto(dto);
        var list = physicalMediaRepository.findById(entity.getPhysicalMedia().getId());

        list.setBorrowing(list.getBorrowing() + 1);
    }
    public SinglePhysicalMediaDto getById(int id){
        var entity = singlePhysicalMediaRepository.findById(id);
        return mappingHelper.toDto(entity);
    }
}
