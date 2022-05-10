package at.htlleonding.logic.model.controller;

import at.htlleonding.dto.AudioBookDto;
import at.htlleonding.dto.MediaDto;
import at.htlleonding.logic.LibraryMgmtLogic;
import at.htlleonding.mapper.model.MediaMappingHelper;
import at.htlleonding.repository.model.MediaRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class MediaLogic extends LibraryMgmtLogic {

    @Inject
    MediaRepository mediaRepository;
    @Inject
    MediaMappingHelper mappingHelper;

    public void insert(MediaDto dto){
        var entity =  mappingHelper.fromDto(dto);
        crudOperations.add(entity);
    }
    public MediaDto getById(int id){
        var entity = mediaRepository.findById(id);
        return mappingHelper.toDto(entity);
    }
}
