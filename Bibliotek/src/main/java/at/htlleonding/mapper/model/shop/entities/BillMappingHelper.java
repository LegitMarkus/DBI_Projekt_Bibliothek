package at.htlleonding.mapper.model.shop.entities;

import at.htlleonding.dto.shop.entities.BillDto;
import at.htlleonding.mapper.MappingHelper;
import at.htlleonding.persistence.shop.entities.Bill;
import at.htlleonding.repository.model.SinglePhysicalMediaRepository;
import at.htlleonding.repository.model.shop.entities.CustomerRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

@ApplicationScoped
public class BillMappingHelper extends MappingHelper {
    public BillDto toDto(Bill entity){
        var dto = om.toDTO(entity);

        if (entity.getCustommer() != null){
            dto.setCustommerId(entity.getCustommer().getId());
        }
        if (entity.getMedia() != null){
            dto.setMediaId(entity.getMedia().getId());
        }

        return dto;
    }

    @Inject
    CustomerRepository customerRepository;
    @Inject
    SinglePhysicalMediaRepository mediaRepository;
    public Bill fromDto(BillDto dto){
        var entity = om.fromDto(dto);

        if (dto.getCustommerId() != null){
            entity.setCustommer(customerRepository.findById(dto.getCustommerId()));
        }
        if (dto.getMediaId() != null){
            entity.setMedia((mediaRepository.findById(dto.getMediaId())));
        }

        return entity;
    }

    public List<BillDto> toDto(List<Bill> entities){
        var dtos = new LinkedList<BillDto>();
        for(var supplier : entities){
            dtos.add(toDto(supplier));
        }
        return dtos;
    }
    public List<Bill> fromDto(List<BillDto> dtos){
        var result = new LinkedList<Bill>();
        for (var dto : dtos) {
            result.add(fromDto(dto));
        }
        return result;
    }

}
