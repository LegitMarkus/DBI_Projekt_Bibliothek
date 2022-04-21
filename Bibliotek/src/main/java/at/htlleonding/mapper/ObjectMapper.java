package at.htlleonding.mapper;

import at.htlleonding.dto.*;
import at.htlleonding.dto.shop.entities.*;
import at.htlleonding.persistence.*;
import at.htlleonding.persistence.shop.entities.*;
import com.github.dockerjava.zerodep.shaded.org.apache.commons.codec.language.bm.Lang;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface ObjectMapper {
    //SHOP ENTITIES
    //BillRepository
    @Mapping(target = "id")
    BillDto toDTO(Bill entity);

    @Mapping(target = "id")
    Bill fromDto(BillDto entity);

    //Custommer
    @Mapping(target = "id")
    CustommerDto toDTO(Customer entity);

    @Mapping(target = "id")
    Customer fromDto(CustommerDto entity);

    //Lending
    @Mapping(target = "id")
    LendingDto toDTO(Lending entity);

    @Mapping(target = "id")
    Lending fromDto(LendingDto entity);

    //Reservation
    @Mapping(target = "id")
    ReservationDto toDTO(Reservation entity);

    @Mapping(target = "id")
    Reservation fromDto(ReservationDto entity);

    //Staff
    @Mapping(target = "id")
    StaffDto toDTO(Staff entity);

    @Mapping(target = "id")
    Staff fromDto(StaffDto entity);



    //NORMAL ENTITIES
    //AudioBookRepository
    @Mapping(target = "id")
    AudioBookDto toDTO(AudioBook entity);

    @Mapping(target = "id")
    AudioBook fromDto(AudioBookDto entity);

    //Author
    @Mapping(target = "id")
    AuthorDto toDTO(Author entity);

    @Mapping(target = "id")
    Author fromDto(AuthorDto entity);

    //Book
    @Mapping(target = "id")
    BookDto toDTO(Book entity);

    @Mapping(target = "id")
    Book fromDto(BookDto entity);

    //DigitalMedia
    @Mapping(target = "id")
    DigitalMediaDto toDTO(DigitalMedia entity);

    @Mapping(target = "id")
    DigitalMedia fromDto(DigitalMediaDto entity);

    //EBook
    @Mapping(target = "id")
    EBookDto toDTO(EBook entity);

    @Mapping(target = "id")
    EBook fromDto(EBookDto entity);

    //Genre
    @Mapping(target = "id")
    GenreDto toDTO(Genre entity);

    @Mapping(target = "id")
    Genre fromDto(GenreDto entity);

    //Language
    @Mapping(target = "id")
    LanguageDto toDTO(Language entity);

    @Mapping(target = "id")
    Language fromDto(LanguageDto entity);

    //Magazine
    @Mapping(target = "id")
    MagazineDto toDTO(Magazine entity);

    @Mapping(target = "id")
    Magazine fromDto(MagazineDto entity);

    //Media
    @Mapping(target = "id")
    MediaDto toDTO(Media entity);

    @Mapping(target = "id")
    Media fromDto(MediaDto entity);

    //Newspaper
    @Mapping(target = "id")
    NewspaperDto toDTO(Newspaper entity);

    @Mapping(target = "id")
    Newspaper fromDto(NewspaperDto entity);

    //PhysicalMedia
    @Mapping(target = "id")
    PhysicalMedia toDTO(PhysicalMedia entity);

    @Mapping(target = "id")
    PhysicalMedia fromDto(PhysicalMediaDto entity);

    //Publisher
    @Mapping(target = "id")
    PublisherDto toDTO(Publisher entity);

    @Mapping(target = "id")
    Publisher fromDto(PublisherDto entity);

    //SinglePhysicalMedia
    @Mapping(target = "id")
    SinglePhysicalMediaDto toDTO(SinglePhysicalMedia entity);

    @Mapping(target = "id")
    SinglePhysicalMedia fromDto(SinglePhysicalMediaDto entity);

    //Speaker
    @Mapping(target = "id")
    SpeakerDto toDTO(Speaker entity);

    @Mapping(target = "id")
    Speaker fromDto(SpeakerDto entity);

    //Topic
    @Mapping(target = "id")
    TopicDto toDTO(Topic entity);

    @Mapping(target = "id")
    Topic fromDto(TopicDto entity);
}
