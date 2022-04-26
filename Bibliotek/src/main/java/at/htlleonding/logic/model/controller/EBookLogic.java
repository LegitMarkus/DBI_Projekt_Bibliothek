package at.htlleonding.logic.model.controller;

import at.htlleonding.dto.EBookDto;
import at.htlleonding.logic.LibraryMgmtLogic;
import at.htlleonding.mapper.model.EBookMappingHelper;
import at.htlleonding.repository.model.EBookRepository;

import javax.inject.Inject;

public class EBookLogic extends LibraryMgmtLogic {

    @Inject
    EBookRepository eBookRepository;
    @Inject
    EBookMappingHelper mappingHelper;

    public void insert(EBookDto dto){
        var entity =  mappingHelper.fromDto(dto);
        crudOperations.add(entity);
    }
    public EBookDto getById(int id){
        var entity = eBookRepository.findById(id);
        return mappingHelper.toDto(entity);
    }
}