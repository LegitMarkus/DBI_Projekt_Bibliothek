package at.htlleonding.logic.model.controller;

import at.htlleonding.dto.MagazineDto;
import at.htlleonding.logic.LibraryMgmtLogic;
import at.htlleonding.mapper.model.MagazineMappingHelper;
import at.htlleonding.repository.model.MagazineRepository;

import javax.inject.Inject;

public class MagazineLogic extends LibraryMgmtLogic {

    @Inject
    MagazineRepository magazineRepository;
    @Inject
    MagazineMappingHelper mappingHelper;

    public void insert(MagazineDto dto){
        var entity =  mappingHelper.fromDto(dto);
        crudOperations.add(entity);
    }
    public MagazineDto getById(int id){
        var entity = magazineRepository.findById(id);
        return mappingHelper.toDto(entity);
    }
}
