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

        book.setBorrowing(book.getBorrowing() - amount);
        book.setBorrowing(book.getBorrowing() + amount);

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

    public void SetOnDisplay(String title, Integer amount){
        var book = bookLogic.getByName(title);
        if (book.getBorrowing() <= 0){
            try {
                throw new BuisnessLogicException("No books are available for sale!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        var dto = bookMappingHelper.fromDto(book);
        var singleList = dto.getSinglePhysicalMedia();
        boolean handled = false;

        book.setBorrowing(book.getBorrowing() - amount);
        book.setFreehandArea(book.getFreehandArea() + amount);

        for (var single: singleList) {
            if (!handled && single.getLendable()){
                single.setLendable(false);
                amount--;
            }
            if (amount == 0){
                handled = true;
            }
        }

        bookLogic.update(book);
    }
    @Inject SinglePhysicalMediaLogic singlePhysicalMediaLogic;
    public void setForSale(String title, int amount) {
        var book = bookLogic.getByName(title);

        var singleList = singlePhysicalMediaRepository.loadAll();
        singleList.removeIf(single -> single.getPhysicalMedia().getTitle() != title);
        //var singleList = bookMappingHelper.fromDto(book).getSinglePhysicalMedia();
        for (var single : singleList){
            if (amount != 0){
                if (single.getLendable() && !single.getForSale()){
                    single.setLendable(false);
                    single.setForSale(true);
                    amount--;
                    book.setBorrowing(book.getBorrowing() - 1);
                    crudOperations.update(single);
                    bookLogic.update(book);
                }
            }else{
                break;
            }
        }
    }
}
