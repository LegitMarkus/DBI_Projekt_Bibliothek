package at.htlleonding.logic.model.controller.shop.logic;

import at.htlleonding.dto.shop.entities.CustomerDto;
import at.htlleonding.logic.LibraryMgmtLogic;
import at.htlleonding.mapper.model.shop.entities.CustomerMappingHelper;
import at.htlleonding.repository.model.shop.entities.CustomerRepository;

import javax.inject.Inject;

public class CustomerLogic extends LibraryMgmtLogic {

    @Inject
    CustomerRepository customerRepository;
    @Inject
    CustomerMappingHelper mappingHelper;

    public void insert(CustomerDto dto){
        var entity =  mappingHelper.fromDto(dto);
        crudOperations.add(entity);
    }
    public CustomerDto getById(int id){
        var entity = customerRepository.findById(id);
        return mappingHelper.toDto(entity);
    }
}