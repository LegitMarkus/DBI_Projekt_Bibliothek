package at.htlleonding.mapper.model;

import at.htlleonding.dto.AuthorDto;
import at.htlleonding.dto.GenreDto;
import at.htlleonding.mapper.MappingHelper;
import at.htlleonding.persistence.Author;
import at.htlleonding.persistence.Genre;
import at.htlleonding.repository.model.MediaRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

@ApplicationScoped
public class GenreMappingHelper extends MappingHelper {
    public GenreDto toDto(Genre entity) {
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

    public Genre fromDto(GenreDto dto) {
        var entity = om.fromDto(dto);

        if (dto.getMediaIds().size() > 0) {
            dto.getMediaIds().forEach(id -> {
                var e = mediaRepository.findById(id);
                entity.getMedias().add(e);
            });
        }
        return entity;
    }

    public List<GenreDto> toDto(List<Genre> entities) {
        var dtos = new LinkedList<GenreDto>();
        for (var entity : entities) {
            dtos.add(toDto(entity));
        }
        return dtos;
    }

    public List<Genre> fromDto(List<GenreDto> dtos) {
        var result = new LinkedList<Genre>();
        for (var dto : dtos) {
            result.add(fromDto(dto));
        }
        return result;
    }
}
