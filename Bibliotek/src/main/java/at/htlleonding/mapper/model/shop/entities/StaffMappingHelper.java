package at.htlleonding.mapper.model.shop.entities;

import at.htlleonding.dto.shop.entities.BillDto;
import at.htlleonding.dto.shop.entities.CustommerDto;
import at.htlleonding.dto.shop.entities.StaffDto;
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
public class StaffMappingHelper extends MappingHelper {
    public StaffDto toDto(Staff entity) {
        var dto = om.toDTO(entity);

        return dto;
    }

    public Staff fromDto(StaffDto dto) {
        var entity = om.fromDto(dto);

        return entity;
    }

    public List<StaffDto> toDto(List<Staff> entities) {
        var dtos = new LinkedList<StaffDto>();
        for (var entity : entities) {
            dtos.add(toDto(entity));
        }
        return dtos;
    }

    public List<Staff> fromDto(List<StaffDto> dtos) {
        var result = new LinkedList<Staff>();
        for (var dto : dtos) {
            result.add(fromDto(dto));
        }
        return result;
    }

}
