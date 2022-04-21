package at.htlleonding.mapper.model.shop.entities;

import at.htlleonding.dto.shop.entities.BillDto;
import at.htlleonding.dto.shop.entities.CustommerDto;
import at.htlleonding.dto.shop.entities.LendingDto;
import at.htlleonding.dto.shop.entities.ReservationDto;
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
public class ReservationMappingHelper extends MappingHelper {
    public ReservationDto toDto(Reservation entity) {
        var dto = om.toDTO(entity);

        if (entity.getCustomer() != null){
            dto.setCustomerId(entity.getCustomer().getId());
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
    public Reservation fromDto(ReservationDto dto){
        var entity = om.fromDto(dto);

        if (dto.getCustomerId() != null){
            entity.setCustomer(custommerRepository.findById(dto.getCustomerId()));
        }
        if (dto.getMediaId() != null){
            entity.setMedia((mediaRepository.findById(dto.getMediaId())));
        }

        return entity;
    }

    public List<ReservationDto> toDto(List<Reservation> entities) {
        var dtos = new LinkedList<ReservationDto>();
        for (var entity : entities) {
            dtos.add(toDto(entity));
        }
        return dtos;
    }

    public List<Reservation> fromDto(List<ReservationDto> dtos) {
        var result = new LinkedList<Reservation>();
        for (var dto : dtos) {
            result.add(fromDto(dto));
        }
        return result;
    }

}
