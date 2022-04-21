package at.htlleonding.mapper.model.shop.entities;

import at.htlleonding.dto.shop.entities.BillDto;
import at.htlleonding.dto.shop.entities.CustommerDto;
import at.htlleonding.dto.shop.entities.LendingDto;
import at.htlleonding.mapper.MappingHelper;
import at.htlleonding.persistence.shop.entities.*;
import at.htlleonding.repository.model.SinglePhysicalMediaRepository;
import at.htlleonding.repository.model.shop.entities.BillRepository;
import at.htlleonding.repository.model.shop.entities.CustommerRepository;
import at.htlleonding.repository.model.shop.entities.LendingRepository;
import at.htlleonding.repository.model.shop.entities.ReservationRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

@ApplicationScoped
public class LendingMappingHelper extends MappingHelper {
    public LendingDto toDto(Lending entity) {
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
    CustommerRepository custommerRepository;
    @Inject
    SinglePhysicalMediaRepository mediaRepository;
    public Lending fromDto(LendingDto dto){
        var entity = om.fromDto(dto);

        if (dto.getCustommerId() != null){
            entity.setCustommer(custommerRepository.findById(dto.getCustommerId()));
        }
        if (dto.getMediaId() != null){
            entity.setMedia((mediaRepository.findById(dto.getMediaId())));
        }

        return entity;
    }

    public List<LendingDto> toDto(List<Lending> entities) {
        var dtos = new LinkedList<LendingDto>();
        for (var entity : entities) {
            dtos.add(toDto(entity));
        }
        return dtos;
    }

    public List<Lending> fromDto(List<LendingDto> dtos) {
        var result = new LinkedList<Lending>();
        for (var dto : dtos) {
            result.add(fromDto(dto));
        }
        return result;
    }
}
