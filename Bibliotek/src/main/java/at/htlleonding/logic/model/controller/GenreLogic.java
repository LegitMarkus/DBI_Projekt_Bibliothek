package at.htlleonding.logic.model.controller;

import at.htlleonding.dto.GenreDto;
import at.htlleonding.logic.LibraryMgmtLogic;
import at.htlleonding.mapper.model.GenreMappingHelper;
import at.htlleonding.repository.model.GenreRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class GenreLogic extends LibraryMgmtLogic {

    @Inject
    GenreRepository genreRepository;
    @Inject
    GenreMappingHelper mappingHelper;

    public void insert(GenreDto dto){
        var entity =  mappingHelper.fromDto(dto);
        crudOperations.add(entity);
    }
    public GenreDto getById(int id){
        var entity = genreRepository.findById(id);
        return mappingHelper.toDto(entity);
    }
}
