package at.htlleonding.logic.model.controller;

import at.htlleonding.dto.NewspaperDto;
import at.htlleonding.dto.TopicDto;
import at.htlleonding.logic.LibraryMgmtLogic;
import at.htlleonding.mapper.model.NewspaperMappingHelper;
import at.htlleonding.mapper.model.TopicMappingHelper;
import at.htlleonding.repository.model.TopicRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class TopicLogic extends LibraryMgmtLogic {

    @Inject
    TopicRepository topicRepository;
    @Inject
    TopicMappingHelper mappingHelper;

    public void insert(TopicDto dto){
        var entity =  mappingHelper.fromDto(dto);
        crudOperations.add(entity);
    }
    public TopicDto getById(int id){
        var entity = topicRepository.findById(id);
        return mappingHelper.toDto(entity);
    }
}
