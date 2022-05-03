package at.htlleonding.mapper.model;

import at.htlleonding.dto.BookDto;
import at.htlleonding.dto.PhysicalMediaDto;
import at.htlleonding.mapper.MappingHelper;
import at.htlleonding.persistence.Book;
import at.htlleonding.persistence.PhysicalMedia;
import at.htlleonding.repository.model.*;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

@ApplicationScoped
public class BookMappingHelper extends MappingHelper {
    public BookDto toDto(Book entity) {
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
        if (entity.getSinglePhysicalMedia().size() > 0) {
            var Ids = new LinkedList<Integer>();
            entity.getAuthors().forEach(e -> {
                var id = e.getId();
                Ids.add(id);
            });
            dto.setSinglePhysicalMediaIds(Ids);
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
    SinglePhysicalMediaRepository singlePhysicalMediaRepository;

    public Book fromDto(BookDto dto) {
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
        if (dto.getSinglePhysicalMediaIds().size() > 0) {
            dto.getSinglePhysicalMediaIds().forEach(id -> {
                var e = singlePhysicalMediaRepository.findById(id);
                entity.getSinglePhysicalMedia().add(e);
            });
        }

        return entity;
    }

    public List<BookDto> toDto(List<Book> entities) {
        var dtos = new LinkedList<BookDto>();
        for (var entity : entities) {
            dtos.add(toDto(entity));
        }
        return dtos;
    }

    public List<Book> fromDto(List<BookDto> dtos) {
        var result = new LinkedList<Book>();
        for (var dto : dtos) {
            result.add(fromDto(dto));
        }
        return result;
    }
}
