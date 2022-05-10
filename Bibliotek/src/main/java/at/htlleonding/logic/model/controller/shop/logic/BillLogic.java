package at.htlleonding.logic.model.controller.shop.logic;

import at.htlleonding.dto.NewspaperDto;
import at.htlleonding.dto.shop.entities.BillDto;
import at.htlleonding.logic.LibraryMgmtLogic;
import at.htlleonding.mapper.model.NewspaperMappingHelper;
import at.htlleonding.mapper.model.shop.entities.BillMappingHelper;
import at.htlleonding.persistence.shop.entities.BillKey;
import at.htlleonding.repository.model.shop.entities.BillRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class BillLogic extends LibraryMgmtLogic {

    @Inject
    BillRepository billRepository;
    @Inject
    BillMappingHelper mappingHelper;

    public void insert(BillDto dto){
        var entity =  mappingHelper.fromDto(dto);
        crudOperations.add(entity);
    }
    public BillDto getById(BillKey id){
        var entity = billRepository.findById(id);
        return mappingHelper.toDto(entity);
    }
}
