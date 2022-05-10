package at.htlleonding.logic.model.controller;

import at.htlleonding.dto.DigitalMediaDto;
import at.htlleonding.logic.LibraryMgmtLogic;
import at.htlleonding.mapper.model.DigitalMediaMappingHelper;
import at.htlleonding.repository.model.DigitalMediaRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class DigitalMediaLogic extends LibraryMgmtLogic {

    @Inject
    DigitalMediaRepository digitalMediaRepository;
    @Inject
    DigitalMediaMappingHelper mappingHelper;

    public void insert(DigitalMediaDto dto){
        var entity =  mappingHelper.fromDto(dto);
        crudOperations.add(entity);
    }
    public DigitalMediaDto getById(int id){
        var entity = digitalMediaRepository.findById(id);
        return mappingHelper.toDto(entity);
    }
}
