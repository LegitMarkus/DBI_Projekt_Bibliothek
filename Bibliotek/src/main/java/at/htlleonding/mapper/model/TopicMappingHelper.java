package at.htlleonding.mapper.model;

import at.htlleonding.dto.AuthorDto;
import at.htlleonding.dto.TopicDto;
import at.htlleonding.mapper.MappingHelper;
import at.htlleonding.persistence.Author;
import at.htlleonding.persistence.Topic;
import at.htlleonding.repository.model.MediaRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

@ApplicationScoped
public class TopicMappingHelper extends MappingHelper {
    public TopicDto toDto(Topic entity) {
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

    public Topic fromDto(TopicDto dto) {
        var entity = om.fromDto(dto);

        if (dto.getMediaIds() != null) {
            dto.getMediaIds().forEach(id -> {
                var e = mediaRepository.findById(id);
                entity.getMedias().add(e);
            });
        }
        return entity;
    }

    public List<TopicDto> toDto(List<Topic> entities) {
        var dtos = new LinkedList<TopicDto>();
        for (var entity : entities) {
            dtos.add(toDto(entity));
        }
        return dtos;
    }

    public List<Topic> fromDto(List<TopicDto> dtos) {
        var result = new LinkedList<Topic>();
        for (var dto : dtos) {
            result.add(fromDto(dto));
        }
        return result;
    }
}
