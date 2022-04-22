package at.htlleonding.mapper.model;

import at.htlleonding.dto.AudioBookDto;
import at.htlleonding.dto.DigitalMediaDto;
import at.htlleonding.dto.shop.entities.StaffDto;
import at.htlleonding.mapper.MappingHelper;
import at.htlleonding.persistence.AudioBook;
import at.htlleonding.persistence.DigitalMedia;
import at.htlleonding.persistence.shop.entities.Staff;
import at.htlleonding.repository.model.*;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

@ApplicationScoped
public class AudioBookMappingHelper extends MappingHelper {
    public AudioBookDto toDto(AudioBook entity) {
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
        if (entity.getTopics().size() > 0) {
            var Ids = new LinkedList<Integer>();
            entity.getTopics().forEach(e -> {
                var id = e.getId();
                Ids.add(id);
            });
            dto.setTopicIds(Ids);

        }
        if (entity.getAuthors().size() > 0) {
            var Ids = new LinkedList<Integer>();
            entity.getAuthors().forEach(e -> {
                var id = e.getId();
                Ids.add(id);
            });
            dto.setAuthorIds(Ids);

        }
        //AudioBook
        if (entity.getSpeakers().size() > 0) {
            var Ids = new LinkedList<Integer>();
            entity.getSpeakers().forEach(e -> {
                var id = e.getId();
                Ids.add(id);
            });
            dto.setSpeakerIds(Ids);
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
    SpeakerRepository speakerRepository;

    public AudioBook fromDto(AudioBookDto dto) {
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
        if (dto.getTopicIds().size() > 0) {
            dto.getTopicIds().forEach(id -> {
                var e = topicRepository.findById(id);
                entity.getTopics().add(e);
            });
        }
        if (dto.getAuthorIds().size() > 0) {
            dto.getAuthorIds().forEach(id -> {
                var e = authorRepository.findById(id);
                entity.getAuthors().add(e);
            });
        }
        //AudioBook
        if (dto.getSpeakerIds().size() > 0) {
            dto.getSpeakerIds().forEach(id -> {
                var e = speakerRepository.findById(id);
                entity.getSpeakers().add(e);
            });
        }
        return entity;
    }

    public List<AudioBookDto> toDto(List<AudioBook> entities) {
        var dtos = new LinkedList<AudioBookDto>();
        for (var entity : entities) {
            dtos.add(toDto(entity));
        }
        return dtos;
    }

    public List<AudioBook> fromDto(List<AudioBookDto> dtos) {
        var result = new LinkedList<AudioBook>();
        for (var dto : dtos) {
            result.add(fromDto(dto));
        }
        return result;
    }
}
