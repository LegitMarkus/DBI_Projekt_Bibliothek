package at.htlleonding.logic.model.controller;

import at.htlleonding.dto.BookDto;
import at.htlleonding.dto.NewspaperDto;
import at.htlleonding.logic.LibraryMgmtLogic;
import at.htlleonding.mapper.model.NewspaperMappingHelper;
import at.htlleonding.persistence.SinglePhysicalMedia;
import at.htlleonding.repository.model.NewspaperRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.time.LocalDate;

@ApplicationScoped
public class NewspaperLogic extends LibraryMgmtLogic {

    @Inject
    NewspaperRepository newspaperRepository;
    @Inject
    NewspaperMappingHelper mappingHelper;

    public void insert(NewspaperDto dto){
        var entity =  mappingHelper.fromDto(dto);
        entity.setTotalNumber(entity.getBorrowing() + entity.getFreehandArea());

        for (int i = 0; i < entity.getBorrowing(); i++){
            var single = new SinglePhysicalMedia();
            single.setPhysicalMedia(entity);
            single.setLendable(true);

            single.setPurchaseDate(LocalDate.now());
            crudOperations.add(single);
            entity.getSinglePhysicalMedia().add(single);
        }
        for (int i = 0; i < entity.getFreehandArea(); i++){
            var single = new SinglePhysicalMedia();
            single.setPhysicalMedia(entity);
            crudOperations.add(single);
            entity.getSinglePhysicalMedia().add(single);
        }

        crudOperations.add(entity);
    }
    public NewspaperDto getById(int id){
        var entity = newspaperRepository.findById(id);
        return mappingHelper.toDto(entity);
    }
    public NewspaperDto getByName(String title){
        var entity = newspaperRepository.findByName(title);
        return mappingHelper.toDto(entity);
    }
}
