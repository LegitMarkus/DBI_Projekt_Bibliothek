package at.htlleonding.logic.model.controller.shop.logic;

import at.htlleonding.dto.NewspaperDto;
import at.htlleonding.dto.shop.entities.StaffDto;
import at.htlleonding.logic.LibraryMgmtLogic;
import at.htlleonding.mapper.model.shop.entities.StaffMappingHelper;
import at.htlleonding.repository.model.shop.entities.StaffRepository;

import javax.inject.Inject;

public class StaffLogic extends LibraryMgmtLogic {

    @Inject
    StaffRepository staffRepository;
    @Inject
    StaffMappingHelper mappingHelper;

    public void insert(StaffDto dto){
        var entity =  mappingHelper.fromDto(dto);
        crudOperations.add(entity);
    }
    public StaffDto getById(int id){
        var entity = staffRepository.findById(id);
        return mappingHelper.toDto(entity);
    }
}
