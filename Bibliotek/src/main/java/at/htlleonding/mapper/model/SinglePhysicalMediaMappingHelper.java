package at.htlleonding.mapper.model;

import at.htlleonding.dto.PublisherDto;
import at.htlleonding.dto.SinglePhysicalMediaDto;
import at.htlleonding.mapper.MappingHelper;
import at.htlleonding.persistence.Publisher;
import at.htlleonding.persistence.SinglePhysicalMedia;
import at.htlleonding.persistence.shop.entities.BillKey;
import at.htlleonding.persistence.shop.entities.LendingKey;
import at.htlleonding.persistence.shop.entities.ReservationKey;
import at.htlleonding.repository.model.MediaRepository;
import at.htlleonding.repository.model.PhysicalMediaRepository;
import at.htlleonding.repository.model.shop.entities.BillRepository;
import at.htlleonding.repository.model.shop.entities.LendingRepository;
import at.htlleonding.repository.model.shop.entities.ReservationRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

@ApplicationScoped
public class SinglePhysicalMediaMappingHelper extends MappingHelper {
    public SinglePhysicalMediaDto toDto(SinglePhysicalMedia entity) {
        var dto = om.toDTO(entity);

        if (entity.getPhysicalMedia() != null){
            dto.setPhysicalMediaId(entity.getPhysicalMedia().getId());
        }
        if (entity.getBills() != null) {
            var Ids = new LinkedList<BillKey>();
            entity.getBills().forEach(e -> {
                var id = e.getId();
                Ids.add(id);
            });
            dto.setBillIds(Ids);
        }
        if (entity.getLendings() != null) {
            var Ids = new LinkedList<Integer>();
            entity.getLendings().forEach(e -> {
                var id = e.getId();
                Ids.add(id);
            });
            dto.setLendingIds(Ids);
        }
        if (entity.getReservations() != null) {
            var Ids = new LinkedList<ReservationKey>();
            entity.getReservations().forEach(e -> {
                var id = e.getId();
                Ids.add(id);
            });
            dto.setReservationIds(Ids);
        }
        return dto;
    }
    @Inject
    PhysicalMediaRepository mediaRepository;
    @Inject
    BillRepository billRepository;
    @Inject
    LendingRepository lendingRepository;
    @Inject
    ReservationRepository reservationRepository;

    public SinglePhysicalMedia fromDto(SinglePhysicalMediaDto dto) {
        var entity = om.fromDto(dto);

        if (dto.getPhysicalMediaId() != null){
            entity.setPhysicalMedia(mediaRepository.findById(dto.getPhysicalMediaId()));
        }
        if (dto.getBillIds() != null) {
            dto.getBillIds().forEach(id -> {
                var e = billRepository.findById(id);
                entity.getBills().add(e);
            });
        }
        if (dto.getLendingIds() != null) {
            dto.getLendingIds().forEach(id -> {
                var e = lendingRepository.findById(id);
                entity.getLendings().add(e);
            });
        }
        if (dto.getReservationIds() != null) {
            dto.getReservationIds().forEach(id -> {
                var e = reservationRepository.findById(id);
                entity.getReservations().add(e);
            });
        }
        return entity;
    }

    public List<SinglePhysicalMediaDto> toDto(List<SinglePhysicalMedia> entities) {
        var dtos = new LinkedList<SinglePhysicalMediaDto>();
        for (var entity : entities) {
            dtos.add(toDto(entity));
        }
        return dtos;
    }

    public List<SinglePhysicalMedia> fromDto(List<SinglePhysicalMediaDto> dtos) {
        var result = new LinkedList<SinglePhysicalMedia>();
        for (var dto : dtos) {
            result.add(fromDto(dto));
        }
        return result;
    }
}