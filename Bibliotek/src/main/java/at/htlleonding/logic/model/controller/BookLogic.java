package at.htlleonding.logic.model.controller;

import at.htlleonding.dto.BookDto;
import at.htlleonding.logic.LibraryMgmtLogic;
import at.htlleonding.mapper.model.BookMappingHelper;
import at.htlleonding.repository.model.BookRepository;

import javax.inject.Inject;

public class BookLogic extends LibraryMgmtLogic {

    @Inject
    BookRepository bookRepository;
    @Inject
    BookMappingHelper mappingHelper;

    public void insert(BookDto dto){
        var entity =  mappingHelper.fromDto(dto);
        crudOperations.add(entity);
    }
    public BookDto getById(int id){
        var entity = bookRepository.findById(id);
        return mappingHelper.toDto(entity);
    }
}
