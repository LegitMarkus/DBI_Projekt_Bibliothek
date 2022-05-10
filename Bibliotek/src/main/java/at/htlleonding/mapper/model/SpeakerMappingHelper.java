package at.htlleonding.mapper.model;

import at.htlleonding.dto.AuthorDto;
import at.htlleonding.dto.SpeakerDto;
import at.htlleonding.mapper.MappingHelper;
import at.htlleonding.persistence.AudioBook;
import at.htlleonding.persistence.Author;
import at.htlleonding.persistence.Speaker;
import at.htlleonding.repository.model.AudioBookRepository;
import at.htlleonding.repository.model.MediaRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

@ApplicationScoped
public class SpeakerMappingHelper extends MappingHelper {
    public SpeakerDto toDto(Speaker entity) {
        var dto = om.toDTO(entity);

        if (entity.getAudioBooks() != null) {
            var Ids = new LinkedList<Integer>();
            entity.getAudioBooks().forEach(e -> {
                var id = e.getId();
                Ids.add(id);
            });
            dto.setAudioBookIds(Ids);
        }
        return dto;
    }

    @Inject
    AudioBookRepository audioBookRepository;

    public Speaker fromDto(SpeakerDto dto) {
        var entity = om.fromDto(dto);

        if (dto.getAudioBookIds() != null) {
            dto.getAudioBookIds().forEach(id -> {
                var e = audioBookRepository.findById(id);
                entity.getAudioBooks().add(e);
            });
        }
        return entity;
    }

    public List<SpeakerDto> toDto(List<Speaker> entities) {
        var dtos = new LinkedList<SpeakerDto>();
        for (var entity : entities) {
            dtos.add(toDto(entity));
        }
        return dtos;
    }

    public List<Speaker> fromDto(List<SpeakerDto> dtos) {
        var result = new LinkedList<Speaker>();
        for (var dto : dtos) {
            result.add(fromDto(dto));
        }
        return result;
    }
}
