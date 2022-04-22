package at.htlleonding.mapper.model;

import at.htlleonding.dto.AuthorDto;
import at.htlleonding.dto.LanguageDto;
import at.htlleonding.mapper.MappingHelper;
import at.htlleonding.persistence.Author;
import at.htlleonding.persistence.Language;
import at.htlleonding.repository.model.MediaRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

@ApplicationScoped
public class LanguageMappingHelper extends MappingHelper {
    public LanguageDto toDto(Language entity) {
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

    public Language fromDto(LanguageDto dto) {
        var entity = om.fromDto(dto);

        if (dto.getMediaIds().size() > 0) {
            dto.getMediaIds().forEach(id -> {
                var e = mediaRepository.findById(id);
                entity.getMedias().add(e);
            });
        }
        return entity;
    }

    public List<LanguageDto> toDto(List<Language> entities) {
        var dtos = new LinkedList<LanguageDto>();
        for (var entity : entities) {
            dtos.add(toDto(entity));
        }
        return dtos;
    }

    public List<Language> fromDto(List<LanguageDto> dtos) {
        var result = new LinkedList<Language>();
        for (var dto : dtos) {
            result.add(fromDto(dto));
        }
        return result;
    }
}
