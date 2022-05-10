package at.htlleonding.logic.model.controller;

import at.htlleonding.dto.NewspaperDto;
import at.htlleonding.dto.PublisherDto;
import at.htlleonding.logic.LibraryMgmtLogic;
import at.htlleonding.mapper.model.NewspaperMappingHelper;
import at.htlleonding.mapper.model.PublisherMappingHelper;
import at.htlleonding.repository.model.PublisherRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class PublisherLogic extends LibraryMgmtLogic {

    @Inject
    PublisherRepository publisherRepository;
    @Inject
    PublisherMappingHelper mappingHelper;

    public void insert(PublisherDto dto){
        var entity =  mappingHelper.fromDto(dto);
        crudOperations.add(entity);
    }
    public PublisherDto getById(int id){
        var entity = publisherRepository.findById(id);
        return mappingHelper.toDto(entity);
    }
}