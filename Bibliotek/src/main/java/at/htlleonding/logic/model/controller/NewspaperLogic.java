package at.htlleonding.logic.model.controller;

import at.htlleonding.dto.NewspaperDto;
import at.htlleonding.logic.LibraryMgmtLogic;
import at.htlleonding.mapper.model.NewspaperMappingHelper;
import at.htlleonding.repository.model.NewspaperRepository;

import javax.inject.Inject;

public class NewspaperLogic extends LibraryMgmtLogic {

    @Inject
    NewspaperRepository newspaperRepository;
    @Inject
    NewspaperMappingHelper mappingHelper;

    public void insert(NewspaperDto dto){
        var entity =  mappingHelper.fromDto(dto);
        crudOperations.add(entity);
    }
    public NewspaperDto getById(int id){
        var entity = newspaperRepository.findById(id);
        return mappingHelper.toDto(entity);
    }
}
