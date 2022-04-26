package at.htlleonding.logic.model.controller;

import at.htlleonding.dto.LanguageDto;
import at.htlleonding.logic.LibraryMgmtLogic;
import at.htlleonding.mapper.model.LanguageMappingHelper;
import at.htlleonding.repository.model.LanguageRepository;

import javax.inject.Inject;

public class LanguageLogic extends LibraryMgmtLogic {

    @Inject
    LanguageRepository languageRepository;
    @Inject
    LanguageMappingHelper mappingHelper;

    public void insert(LanguageDto dto){
        var entity =  mappingHelper.fromDto(dto);
        crudOperations.add(entity);
    }
    public LanguageDto getById(int id){
        var entity = languageRepository.findById(id);
        return mappingHelper.toDto(entity);
    }
}
