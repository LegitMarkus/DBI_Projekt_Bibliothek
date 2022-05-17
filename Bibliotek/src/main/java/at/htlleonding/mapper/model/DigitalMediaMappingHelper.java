package at.htlleonding.mapper.model;

import at.htlleonding.dto.DigitalMediaDto;
import at.htlleonding.dto.MediaDto;
import at.htlleonding.mapper.MappingHelper;
import at.htlleonding.persistence.DigitalMedia;
import at.htlleonding.persistence.Media;
import at.htlleonding.persistence.shop.entities.LendingKey;
import at.htlleonding.repository.model.*;
import at.htlleonding.repository.model.shop.entities.LendingRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

@ApplicationScoped
public class DigitalMediaMappingHelper extends MappingHelper {
    public DigitalMediaDto toDto(DigitalMedia entity) {
        var dto = om.toDTO(entity);
        //Media
        if (entity.getPublisher() != null){
            dto.setPublisherId(entity.getPublisher().getId());
        }
        if (entity.getGenre() != null){
            dto.setGenreId(entity.getGenre().getId());
        }
        if (entity.getLanguage() != null){
            dto.setLanguageId(entity.getLanguage().getId());
        }
        if (entity.getTopics() != null) {
            var Ids = new LinkedList<Integer>();
            entity.getTopics().forEach(e -> {
                var id = e.getId();
                Ids.add(id);
            });
            dto.setTopicIds(Ids);

        }
        if (entity.getAuthors() != null) {
            var Ids = new LinkedList<Integer>();
            entity.getAuthors().forEach(e -> {
                var id = e.getId();
                Ids.add(id);
            });
            dto.setAuthorIds(Ids);

        }
        if (entity.getLendings() != null) {
            var Ids = new LinkedList<Integer>();
            entity.getLendings().forEach(e -> {
                var id = e.getId();
                Ids.add(id);
            });
            dto.setLendingIds(Ids);
        }

        return dto;
    }

    @Inject
    PublisherRepository publisherRepository;
    @Inject
    GenreRepository genreRepository;
    @Inject
    LanguageRepository languageRepository;
    @Inject
    TopicRepository topicRepository;
    @Inject
    AuthorRepository authorRepository;
    @Inject
    LendingRepository lendingRepository;

    public DigitalMedia fromDto(DigitalMediaDto dto) {
        var entity = om.fromDto(dto);
        //Media
        if (dto.getPublisherId() != null){
            entity.setPublisher(publisherRepository.findById(dto.getPublisherId()));
        }
        if (dto.getGenreId() != null){
            entity.setGenre(genreRepository.findById(dto.getGenreId()));
        }
        if (dto.getLanguageId() != null){
            entity.setLanguage(languageRepository.findById(dto.getLanguageId()));
        }
        if (dto.getTopicIds() != null) {
            dto.getTopicIds().forEach(id -> {
                var e = topicRepository.findById(id);
                entity.getTopics().add(e);
            });
        }
        if (dto.getAuthorIds() != null) {
            dto.getAuthorIds().forEach(id -> {
                var e = authorRepository.findById(id);
                entity.getAuthors().add(e);
            });
        }
        if (dto.getLendingIds() != null) {
            dto.getLendingIds().forEach(id -> {
                var e = lendingRepository.findById(id);
                entity.getLendings().add(e);
            });
        }

        return entity;
    }

    public List<DigitalMediaDto> toDto(List<DigitalMedia> entities) {
        var dtos = new LinkedList<DigitalMediaDto>();
        for (var entity : entities) {
            dtos.add(toDto(entity));
        }
        return dtos;
    }

    public List<DigitalMedia> fromDto(List<DigitalMediaDto> dtos) {
        var result = new LinkedList<DigitalMedia>();
        for (var dto : dtos) {
            result.add(fromDto(dto));
        }
        return result;
    }
}
