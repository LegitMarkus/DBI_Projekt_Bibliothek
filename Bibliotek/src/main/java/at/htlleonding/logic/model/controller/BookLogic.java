package at.htlleonding.logic.model.controller;

import at.htlleonding.dto.BookDto;
import at.htlleonding.logic.LibraryMgmtLogic;
import at.htlleonding.mapper.model.BookMappingHelper;
import at.htlleonding.persistence.SinglePhysicalMedia;
import at.htlleonding.repository.model.BookRepository;
import at.htlleonding.repository.model.SinglePhysicalMediaRepository;
import net.bytebuddy.asm.Advice;

import javax.inject.Inject;
import java.time.LocalDate;

public class BookLogic extends LibraryMgmtLogic {

    @Inject
    BookRepository bookRepository;
    @Inject
    SinglePhysicalMediaRepository singlePhysicalMediaRepository;
    @Inject
    BookMappingHelper mappingHelper;

    public void insert(BookDto dto){
        var entity =  mappingHelper.fromDto(dto);
        entity.setTotalNumber(entity.getBorrowing() + entity.getFreehandArea());

        for (int i = 0; i < entity.getBorrowing(); i++){
            var single = new SinglePhysicalMedia();
            single.setPhysicalMedia(entity);
            single.setLendable(true);

            single.setPurchaseDate(LocalDate.now());
            crudOperations.add(single);
            entity.getSingle().add(single);
        }
        for (int i = 0; i < entity.getFreehandArea(); i++){
            var single = new SinglePhysicalMedia();
            single.setPhysicalMedia(entity);
            crudOperations.add(single);
            entity.getSingle().add(single);
        }

        crudOperations.add(entity);

    }
    public BookDto getById(int id){
        var entity = bookRepository.findById(id);
        return mappingHelper.toDto(entity);
    }
    public BookDto getByName(String title){
        var entity = bookRepository.findByName(title);
        return mappingHelper.toDto(entity);
    }
}
