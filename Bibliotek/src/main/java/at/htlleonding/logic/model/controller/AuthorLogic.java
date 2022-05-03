package at.htlleonding.logic.model.controller;

import at.htlleonding.dto.AuthorDto;
import at.htlleonding.logic.LibraryMgmtLogic;
import at.htlleonding.mapper.model.AuthorMappingHelper;
import at.htlleonding.repository.model.AuthorRepository;

import javax.inject.Inject;
import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;

public class AuthorLogic extends LibraryMgmtLogic {

    @Inject
    AuthorRepository authorRepository;
    @Inject
    AuthorMappingHelper mappingHelper;

    public void insert(AuthorDto dto){
        var entity =  mappingHelper.fromDto(dto);
        crudOperations.add(entity);
    }
    public AuthorDto getById(int id){
        var entity = authorRepository.findById(id);
        return mappingHelper.toDto(entity);
    }
    public AuthorDto getByName(String firstname, String lastname){
        var entity = authorRepository.findByName(firstname, lastname);
        return mappingHelper.toDto(entity);
    }
}
