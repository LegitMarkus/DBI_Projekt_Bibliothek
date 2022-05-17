package at.htlleonding.logic.model.controller;

import at.htlleonding.dto.BookDto;
import at.htlleonding.dto.NewspaperDto;
import at.htlleonding.dto.SinglePhysicalMediaDto;
import at.htlleonding.dto.shop.entities.LendingDto;
import at.htlleonding.logic.LibraryMgmtLogic;
import at.htlleonding.mapper.model.BookMappingHelper;
import at.htlleonding.mapper.model.NewspaperMappingHelper;
import at.htlleonding.mapper.model.SinglePhysicalMediaMappingHelper;
import at.htlleonding.persistence.SinglePhysicalMedia;
import at.htlleonding.repository.model.PhysicalMediaRepository;
import at.htlleonding.repository.model.SinglePhysicalMediaRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class SinglePhysicalMediaLogic extends LibraryMgmtLogic {

    @Inject
    SinglePhysicalMediaRepository singlePhysicalMediaRepository;
    @Inject
    SinglePhysicalMediaMappingHelper mappingHelper;
    @Inject
    PhysicalMediaRepository physicalMediaRepository;

    public void insert(SinglePhysicalMediaDto dto){
        var entity =  mappingHelper.fromDto(dto);

        crudOperations.add(entity);
    }
    public void rent(SinglePhysicalMediaDto dto){
        var entity =  mappingHelper.fromDto(dto);
        var list = physicalMediaRepository.findById(entity.getPhysicalMedia().getId());

        list.setBorrowing(list.getBorrowing() - 1);
    }
    public void returnRented(SinglePhysicalMediaDto dto){
        var entity =  mappingHelper.fromDto(dto);
        var list = physicalMediaRepository.findById(entity.getPhysicalMedia().getId());

        list.setBorrowing(list.getBorrowing() + 1);
    }
    public SinglePhysicalMediaDto getById(int id){
        var entity = singlePhysicalMediaRepository.findById(id);
        return mappingHelper.toDto(entity);
    }
    //sale
    @Inject BookLogic bookLogic;
    @Inject
    BookMappingHelper bookMappingHelper;
    public void setBookForSale(String title, Integer amount){
        var book = bookLogic.getByName(title);
        if (book.getBorrowing() <= 0){
            try {
                throw new BuisnessLogicException("No books are available for sale!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (book.getBorrowing() == 0){
            try {
                throw new BuisnessLogicException("Not enough books are available for rent!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        var dto = bookMappingHelper.fromDto(book);
        var singleList = dto.getSinglePhysicalMedia();
        boolean handled = false;
        for (var single: singleList) {
            if (!handled && single.getLendable()){
                single.setForSale(true);
                single.setLendable(false);
                amount--;
            }
            if (amount == 0){
                handled = true;
            }
        }
        book.setBorrowing(book.getBorrowing() - 1);

        bookLogic.update(book);
    }

    @Inject NewspaperLogic newspaperLogic;
    public void setNewpaperForSale(String title, Integer amount){
        var newspaper = newspaperLogic.getByName(title);
        if (newspaper.getBorrowing() <= 0){
            try {
                throw new BuisnessLogicException("No newspapers are available for sale!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (newspaper.getBorrowing() == 0){
            try {
                throw new BuisnessLogicException("Not enough newspapers are available for rent!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        var singleList = singlePhysicalMediaRepository.loadAllNewspaperForBorrowing(title);
        boolean handled = false;
        for (var single: singleList) {
            if (!handled){
                single.setForSale(true);
                single.setLendable(false);
                amount--;
            }
            if (amount == 0){
                handled = true;
            }
        }
        newspaper.setBorrowing(newspaper.getBorrowing() - 1);

        newspaperLogic.update(newspaper);
    }

    @Inject MagazineLogic magazineLogic;
    public void setMagazineForSale(String title, Integer amount){
        var magazine = magazineLogic.getByName(title);
        if (magazine.getBorrowing() <= 0){
            try {
                throw new BuisnessLogicException("No magazines are available for sale!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (magazine.getBorrowing() == 0){
            try {
                throw new BuisnessLogicException("Not enough magazines are available for rent!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        var singleList = singlePhysicalMediaRepository.loadAllMagazineForBorrowing(title);
        boolean handled = false;
        for (var single: singleList) {
            if (!handled){
                single.setForSale(true);
                single.setLendable(false);
                amount--;
            }
            if (amount == 0){
                handled = true;
            }
        }
        magazine.setBorrowing(magazine.getBorrowing() - 1);

        magazineLogic.update(magazine);
    }
}
