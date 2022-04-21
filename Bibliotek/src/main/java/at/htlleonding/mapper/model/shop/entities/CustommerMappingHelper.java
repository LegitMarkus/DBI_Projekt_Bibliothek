package at.htlleonding.mapper.model.shop.entities;

import at.htlleonding.dto.shop.entities.BillDto;
import at.htlleonding.dto.shop.entities.CustommerDto;
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
public class CustommerMappingHelper extends MappingHelper {
    public CustommerDto toDto(Customer entity) {
        var dto = om.toDTO(entity);

        if (entity.getBills().size() > 0) {
            var Ids = new LinkedList<BillKey>();
            entity.getBills().forEach(e -> {
                var id = e.getId();
                Ids.add(id);
            });
            dto.setBillIds(Ids);
        }

        if (entity.getLendings().size() > 0) {
            var Ids = new LinkedList<LendingKey>();
            entity.getLendings().forEach(e -> {
                var id = e.getId();
                Ids.add(id);
            });
            dto.setLendingIds(Ids);

        }
        if (entity.getReservations().size() > 0) {
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
    BillRepository billRepository;
    @Inject
    LendingRepository lendingRepository;
    @Inject
    ReservationRepository reservationRepository;

    public Customer fromDto(CustommerDto dto) {
        var entity = om.fromDto(dto);

        if (dto.getBillIds().size() > 0) {
            dto.getBillIds().forEach(id -> {
                var e = billRepository.findById(id);
                entity.getBills().add(e);
            });
        }
        if (dto.getLendingIds().size() > 0) {
            dto.getLendingIds().forEach(id -> {
                var e = lendingRepository.findById(id);
                entity.getLendings().add(e);
            });
        }
        if (dto.getReservationIds().size() > 0) {
            dto.getReservationIds().forEach(id -> {
                var e = reservationRepository.findById(id);
                entity.getReservations().add(e);
            });
        }

        return entity;
    }

    public List<CustommerDto> toDto(List<Customer> entities) {
        var dtos = new LinkedList<CustommerDto>();
        for (var entity : entities) {
            dtos.add(toDto(entity));
        }
        return dtos;
    }

    public List<Customer> fromDto(List<CustommerDto> dtos) {
        var result = new LinkedList<Customer>();
        for (var dto : dtos) {
            result.add(fromDto(dto));
        }
        return result;
    }
}
