package at.htlleonding.mapper.model;

import at.htlleonding.dto.AuthorDto;
import at.htlleonding.dto.PublisherDto;
import at.htlleonding.mapper.MappingHelper;
import at.htlleonding.persistence.Author;
import at.htlleonding.persistence.Publisher;
import at.htlleonding.repository.model.MediaRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

@ApplicationScoped
public class PublisherMappingHelper extends MappingHelper {
    public PublisherDto toDto(Publisher entity) {
        var dto = om.toDTO(entity);

        if (entity.getMedias() != null) {
            var Ids = new LinkedList<Integer>();
            entity.getMedias().forEach(e -> {
                var id = e.getId();
                Ids.add(id);
            });
            dto.setMediaIds(Ids);
        }
        return dto;
    }

    @Inject
    MediaRepository mediaRepository;

    public Publisher fromDto(PublisherDto dto) {
        var entity = om.fromDto(dto);

        if (dto.getMediaIds() != null) {
            dto.getMediaIds().forEach(id -> {
                var e = mediaRepository.findById(id);
                entity.getMedias().add(e);
            });
        }
        return entity;
    }

    public List<PublisherDto> toDto(List<Publisher> entities) {
        var dtos = new LinkedList<PublisherDto>();
        for (var entity : entities) {
            dtos.add(toDto(entity));
        }
        return dtos;
    }

    public List<Publisher> fromDto(List<PublisherDto> dtos) {
        var result = new LinkedList<Publisher>();
        for (var dto : dtos) {
            result.add(fromDto(dto));
        }
        return result;
    }
}
