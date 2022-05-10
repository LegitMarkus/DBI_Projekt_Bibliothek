package at.htlleonding.logic.model.controller;

import at.htlleonding.dto.NewspaperDto;
import at.htlleonding.dto.SpeakerDto;
import at.htlleonding.logic.LibraryMgmtLogic;
import at.htlleonding.mapper.model.NewspaperMappingHelper;
import at.htlleonding.mapper.model.SpeakerMappingHelper;
import at.htlleonding.repository.model.SpeakerRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class SpeakerLogic extends LibraryMgmtLogic {

    @Inject
    SpeakerRepository speakerRepository;
    @Inject
    SpeakerMappingHelper mappingHelper;

    public void insert(SpeakerDto dto){
        var entity =  mappingHelper.fromDto(dto);
        crudOperations.add(entity);
    }
    public SpeakerDto getById(int id){
        var entity = speakerRepository.findById(id);
        return mappingHelper.toDto(entity);
    }
}
