package at.htlleonding.logic.model.controller.shop.logic;

import at.htlleonding.dto.NewspaperDto;
import at.htlleonding.dto.shop.entities.ReservationDto;
import at.htlleonding.logic.LibraryMgmtLogic;
import at.htlleonding.mapper.model.NewspaperMappingHelper;
import at.htlleonding.mapper.model.shop.entities.ReservationMappingHelper;
import at.htlleonding.persistence.shop.entities.ReservationKey;
import at.htlleonding.repository.model.NewspaperRepository;
import at.htlleonding.repository.model.shop.entities.ReservationRepository;

import javax.inject.Inject;

public class ReservationLogic extends LibraryMgmtLogic {

    @Inject
    ReservationRepository newspaperRepository;
    @Inject
    ReservationMappingHelper mappingHelper;

    public void insert(ReservationDto dto){
        var entity =  mappingHelper.fromDto(dto);
        crudOperations.add(entity);
    }
    public ReservationDto getById(ReservationKey id){
        var entity = newspaperRepository.findById(id);
        return mappingHelper.toDto(entity);
    }
}
