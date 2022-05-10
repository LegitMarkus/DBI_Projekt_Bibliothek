package at.htlleonding.logic.model.controller;

import at.htlleonding.dto.MagazineDto;
import at.htlleonding.dto.NewspaperDto;
import at.htlleonding.logic.LibraryMgmtLogic;
import at.htlleonding.mapper.model.MagazineMappingHelper;
import at.htlleonding.persistence.SinglePhysicalMedia;
import at.htlleonding.repository.model.MagazineRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.time.LocalDate;

@ApplicationScoped
public class MagazineLogic extends LibraryMgmtLogic {

    @Inject
    MagazineRepository magazineRepository;
    @Inject
    MagazineMappingHelper mappingHelper;

    public void insert(MagazineDto dto){
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
    public MagazineDto getById(int id){
        var entity = magazineRepository.findById(id);
        return mappingHelper.toDto(entity);
    }
    public MagazineDto getByName(String title){
        var entity = magazineRepository.findByName(title);
        return mappingHelper.toDto(entity);
    }
}
