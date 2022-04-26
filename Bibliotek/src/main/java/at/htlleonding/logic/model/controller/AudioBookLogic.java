package at.htlleonding.logic.model.controller;

import at.htlleonding.dto.AudioBookDto;
import at.htlleonding.logic.LibraryMgmtLogic;
import at.htlleonding.mapper.model.AudioBookMappingHelper;
import at.htlleonding.repository.model.AudioBookRepository;

import javax.inject.Inject;

public class AudioBookLogic extends LibraryMgmtLogic {

    @Inject
    AudioBookRepository audioBookRepository;
    @Inject
    AudioBookMappingHelper mappingHelper;

    public void insert(AudioBookDto dto){
        var entity =  mappingHelper.fromDto(dto);
        crudOperations.add(entity);
    }
    public AudioBookDto getById(int id){
        var entity = audioBookRepository.findById(id);
        return mappingHelper.toDto(entity);
    }
}
