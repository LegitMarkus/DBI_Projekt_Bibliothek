package at.htlleonding.mapper.model.shop.entities;

import at.htlleonding.dto.shop.entities.CustomerDto;
import at.htlleonding.mapper.MappingHelper;
import at.htlleonding.persistence.shop.entities.*;
import at.htlleonding.repository.model.shop.entities.BillRepository;
import at.htlleonding.repository.model.shop.entities.LendingRepository;
import at.htlleonding.repository.model.shop.entities.ReservationRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

@ApplicationScoped
public class CustomerMappingHelper extends MappingHelper {
    public CustomerDto toDto(Customer entity) {
        var dto = om.toDTO(entity);

        if (entity.getBills() != null) {
            var Ids = new LinkedList<BillKey>();
            entity.getBills().forEach(e -> {
                var id = e.getId();
                Ids.add(id);
            });
            dto.setBillIds(Ids);
        }

        if (entity.getLendings() != null) {
            var Ids = new LinkedList<LendingKey>();
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
    BillRepository billRepository;
    @Inject
    LendingRepository lendingRepository;
    @Inject
    ReservationRepository reservationRepository;

    public Customer fromDto(CustomerDto dto) {
        var entity = om.fromDto(dto);

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

    public List<CustomerDto> toDto(List<Customer> entities) {
        var dtos = new LinkedList<CustomerDto>();
        for (var entity : entities) {
            dtos.add(toDto(entity));
        }
        return dtos;
    }

    public List<Customer> fromDto(List<CustomerDto> dtos) {
        var result = new LinkedList<Customer>();
        for (var dto : dtos) {
            result.add(fromDto(dto));
        }
        return result;
    }
}
