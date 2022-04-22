package at.htlleonding.mapper.model;

import at.htlleonding.dto.AudioBookDto;
import at.htlleonding.dto.AuthorDto;
import at.htlleonding.mapper.MappingHelper;
import at.htlleonding.persistence.AudioBook;
import at.htlleonding.persistence.Author;
import at.htlleonding.repository.model.*;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

@ApplicationScoped
public class AuthorMappingHelper extends MappingHelper {
    public AuthorDto toDto(Author entity) {
        var dto = om.toDTO(entity);

        if (entity.getMedias().size() > 0) {
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

    public Author fromDto(AuthorDto dto) {
        var entity = om.fromDto(dto);

        if (dto.getMediaIds().size() > 0) {
            dto.getMediaIds().forEach(id -> {
                var e = mediaRepository.findById(id);
                entity.getMedias().add(e);
            });
        }
        return entity;
    }

    public List<AuthorDto> toDto(List<Author> entities) {
        var dtos = new LinkedList<AuthorDto>();
        for (var entity : entities) {
            dtos.add(toDto(entity));
        }
        return dtos;
    }

    public List<Author> fromDto(List<AuthorDto> dtos) {
        var result = new LinkedList<Author>();
        for (var dto : dtos) {
            result.add(fromDto(dto));
        }
        return result;
    }

}
