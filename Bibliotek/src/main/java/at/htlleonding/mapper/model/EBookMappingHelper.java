package at.htlleonding.mapper.model;

import at.htlleonding.dto.EBookDto;
import at.htlleonding.dto.MediaDto;
import at.htlleonding.mapper.MappingHelper;
import at.htlleonding.persistence.EBook;
import at.htlleonding.persistence.Media;
import at.htlleonding.persistence.shop.entities.LendingKey;
import at.htlleonding.repository.model.*;
import at.htlleonding.repository.model.shop.entities.LendingRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

@ApplicationScoped
public class EBookMappingHelper extends MappingHelper {
    public EBookDto toDto(EBook entity) {
        var dto = om.toDTO(entity);

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

    public EBook fromDto(EBookDto dto) {
        var entity = om.fromDto(dto);

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

    public List<EBookDto> toDto(List<EBook> entities) {
        var dtos = new LinkedList<EBookDto>();
        for (var entity : entities) {
            dtos.add(toDto(entity));
        }
        return dtos;
    }

    public List<EBook> fromDto(List<EBookDto> dtos) {
        var result = new LinkedList<EBook>();
        for (var dto : dtos) {
            result.add(fromDto(dto));
        }
        return result;
    }
}
