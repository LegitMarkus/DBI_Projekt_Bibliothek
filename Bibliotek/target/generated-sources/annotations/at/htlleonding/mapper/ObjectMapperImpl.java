package at.htlleonding.mapper;

import at.htlleonding.dto.AudioBookDto;
import at.htlleonding.dto.AuthorDto;
import at.htlleonding.dto.BookDto;
import at.htlleonding.dto.DigitalMediaDto;
import at.htlleonding.dto.EBookDto;
import at.htlleonding.dto.GenreDto;
import at.htlleonding.dto.LanguageDto;
import at.htlleonding.dto.MagazineDto;
import at.htlleonding.dto.MediaDto;
import at.htlleonding.dto.NewspaperDto;
import at.htlleonding.dto.PhysicalMediaDto;
import at.htlleonding.dto.PublisherDto;
import at.htlleonding.dto.SinglePhysicalMediaDto;
import at.htlleonding.dto.SpeakerDto;
import at.htlleonding.dto.TopicDto;
import at.htlleonding.dto.shop.entities.BillDto;
import at.htlleonding.dto.shop.entities.CustomerDto;
import at.htlleonding.dto.shop.entities.LendingDto;
import at.htlleonding.dto.shop.entities.ReservationDto;
import at.htlleonding.dto.shop.entities.StaffDto;
import at.htlleonding.persistence.AudioBook;
import at.htlleonding.persistence.Author;
import at.htlleonding.persistence.Book;
import at.htlleonding.persistence.DigitalMedia;
import at.htlleonding.persistence.EBook;
import at.htlleonding.persistence.Genre;
import at.htlleonding.persistence.Language;
import at.htlleonding.persistence.Magazine;
import at.htlleonding.persistence.Media;
import at.htlleonding.persistence.Newspaper;
import at.htlleonding.persistence.PhysicalMedia;
import at.htlleonding.persistence.Publisher;
import at.htlleonding.persistence.SinglePhysicalMedia;
import at.htlleonding.persistence.Speaker;
import at.htlleonding.persistence.Topic;
import at.htlleonding.persistence.shop.entities.Bill;
import at.htlleonding.persistence.shop.entities.Customer;
import at.htlleonding.persistence.shop.entities.Lending;
import at.htlleonding.persistence.shop.entities.Reservation;
import at.htlleonding.persistence.shop.entities.Staff;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-03T12:08:37+0200",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@ApplicationScoped
public class ObjectMapperImpl implements ObjectMapper {

    @Override
    public BillDto toDTO(Bill entity) {
        if ( entity == null ) {
            return null;
        }

        BillDto billDto = new BillDto();

        billDto.setId( entity.getId() );
        billDto.setPrice( entity.getPrice() );

        return billDto;
    }

    @Override
    public Bill fromDto(BillDto entity) {
        if ( entity == null ) {
            return null;
        }

        Bill bill = new Bill();

        bill.setId( entity.getId() );
        bill.setPrice( entity.getPrice() );

        return bill;
    }

    @Override
    public CustomerDto toDTO(Customer entity) {
        if ( entity == null ) {
            return null;
        }

        CustomerDto customerDto = new CustomerDto();

        customerDto.setId( entity.getId() );
        customerDto.setCustomerNumber( entity.getCustomerNumber() );
        customerDto.setFirstName( entity.getFirstName() );
        customerDto.setLastName( entity.getLastName() );

        return customerDto;
    }

    @Override
    public Customer fromDto(CustomerDto entity) {
        if ( entity == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( entity.getId() );
        customer.setCustomerNumber( entity.getCustomerNumber() );
        customer.setFirstName( entity.getFirstName() );
        customer.setLastName( entity.getLastName() );

        return customer;
    }

    @Override
    public LendingDto toDTO(Lending entity) {
        if ( entity == null ) {
            return null;
        }

        LendingDto lendingDto = new LendingDto();

        lendingDto.setId( entity.getId() );
        lendingDto.setLendingDate( entity.getLendingDate() );
        lendingDto.setReturnDate( entity.getReturnDate() );
        lendingDto.setExtension( entity.getExtension() );

        return lendingDto;
    }

    @Override
    public Lending fromDto(LendingDto entity) {
        if ( entity == null ) {
            return null;
        }

        Lending lending = new Lending();

        lending.setId( entity.getId() );
        lending.setLendingDate( entity.getLendingDate() );
        lending.setReturnDate( entity.getReturnDate() );
        lending.setExtension( entity.getExtension() );

        return lending;
    }

    @Override
    public ReservationDto toDTO(Reservation entity) {
        if ( entity == null ) {
            return null;
        }

        ReservationDto reservationDto = new ReservationDto();

        reservationDto.setId( entity.getId() );
        reservationDto.setReservationDate( entity.getReservationDate() );

        return reservationDto;
    }

    @Override
    public Reservation fromDto(ReservationDto entity) {
        if ( entity == null ) {
            return null;
        }

        Reservation reservation = new Reservation();

        reservation.setId( entity.getId() );
        reservation.setReservationDate( entity.getReservationDate() );

        return reservation;
    }

    @Override
    public StaffDto toDTO(Staff entity) {
        if ( entity == null ) {
            return null;
        }

        StaffDto staffDto = new StaffDto();

        staffDto.setId( entity.getId() );
        staffDto.setAge( entity.getAge() );
        staffDto.setEmail( entity.getEmail() );
        staffDto.setSalary( entity.getSalary() );

        return staffDto;
    }

    @Override
    public Staff fromDto(StaffDto entity) {
        if ( entity == null ) {
            return null;
        }

        Staff staff = new Staff();

        staff.setId( entity.getId() );
        staff.setAge( entity.getAge() );
        staff.setEmail( entity.getEmail() );
        staff.setSalary( entity.getSalary() );

        return staff;
    }

    @Override
    public AudioBookDto toDTO(AudioBook entity) {
        if ( entity == null ) {
            return null;
        }

        AudioBookDto audioBookDto = new AudioBookDto();

        audioBookDto.setId( entity.getId() );
        audioBookDto.setTitle( entity.getTitle() );
        audioBookDto.setPublisherDate( entity.getPublisherDate() );
        audioBookDto.setTranslation( entity.isTranslation() );
        audioBookDto.setUrl( entity.getUrl() );

        return audioBookDto;
    }

    @Override
    public AudioBook fromDto(AudioBookDto entity) {
        if ( entity == null ) {
            return null;
        }

        AudioBook audioBook = new AudioBook();

        audioBook.setId( entity.getId() );
        audioBook.setTitle( entity.getTitle() );
        audioBook.setPublisherDate( entity.getPublisherDate() );
        audioBook.setTranslation( entity.isTranslation() );
        audioBook.setUrl( entity.getUrl() );

        return audioBook;
    }

    @Override
    public AuthorDto toDTO(Author entity) {
        if ( entity == null ) {
            return null;
        }

        AuthorDto authorDto = new AuthorDto();

        authorDto.setId( entity.getId() );
        authorDto.setFirstname( entity.getFirstname() );
        authorDto.setLastname( entity.getLastname() );
        authorDto.setBirthDate( entity.getBirthDate() );
        authorDto.setDeathDate( entity.getDeathDate() );

        return authorDto;
    }

    @Override
    public Author fromDto(AuthorDto entity) {
        if ( entity == null ) {
            return null;
        }

        Author author = new Author();

        author.setId( entity.getId() );
        author.setFirstname( entity.getFirstname() );
        author.setLastname( entity.getLastname() );
        author.setBirthDate( entity.getBirthDate() );
        author.setDeathDate( entity.getDeathDate() );

        return author;
    }

    @Override
    public BookDto toDTO(Book entity) {
        if ( entity == null ) {
            return null;
        }

        BookDto bookDto = new BookDto();

        bookDto.setId( entity.getId() );
        bookDto.setTitle( entity.getTitle() );
        bookDto.setPublisherDate( entity.getPublisherDate() );
        bookDto.setTranslation( entity.isTranslation() );
        bookDto.setTotalNumber( entity.getTotalNumber() );
        bookDto.setBorrowing( entity.getBorrowing() );
        bookDto.setFreehandArea( entity.getFreehandArea() );
        bookDto.setSignature( entity.getSignature() );

        return bookDto;
    }

    @Override
    public Book fromDto(BookDto entity) {
        if ( entity == null ) {
            return null;
        }

        Book book = new Book();

        book.setId( entity.getId() );
        book.setTitle( entity.getTitle() );
        book.setPublisherDate( entity.getPublisherDate() );
        book.setTranslation( entity.isTranslation() );
        book.setTotalNumber( entity.getTotalNumber() );
        book.setBorrowing( entity.getBorrowing() );
        book.setFreehandArea( entity.getFreehandArea() );
        book.setSignature( entity.getSignature() );

        return book;
    }

    @Override
    public DigitalMediaDto toDTO(DigitalMedia entity) {
        if ( entity == null ) {
            return null;
        }

        DigitalMediaDto digitalMediaDto = new DigitalMediaDto();

        digitalMediaDto.setId( entity.getId() );
        digitalMediaDto.setTitle( entity.getTitle() );
        digitalMediaDto.setPublisherDate( entity.getPublisherDate() );
        digitalMediaDto.setTranslation( entity.isTranslation() );
        digitalMediaDto.setUrl( entity.getUrl() );

        return digitalMediaDto;
    }

    @Override
    public DigitalMedia fromDto(DigitalMediaDto entity) {
        if ( entity == null ) {
            return null;
        }

        DigitalMedia digitalMedia = new DigitalMedia();

        digitalMedia.setId( entity.getId() );
        digitalMedia.setTitle( entity.getTitle() );
        digitalMedia.setPublisherDate( entity.getPublisherDate() );
        digitalMedia.setTranslation( entity.isTranslation() );
        digitalMedia.setUrl( entity.getUrl() );

        return digitalMedia;
    }

    @Override
    public EBookDto toDTO(EBook entity) {
        if ( entity == null ) {
            return null;
        }

        EBookDto eBookDto = new EBookDto();

        eBookDto.setId( entity.getId() );
        eBookDto.setTitle( entity.getTitle() );
        eBookDto.setPublisherDate( entity.getPublisherDate() );
        eBookDto.setTranslation( entity.isTranslation() );
        eBookDto.setUrl( entity.getUrl() );

        return eBookDto;
    }

    @Override
    public EBook fromDto(EBookDto entity) {
        if ( entity == null ) {
            return null;
        }

        EBook eBook = new EBook();

        eBook.setId( entity.getId() );
        eBook.setTitle( entity.getTitle() );
        eBook.setPublisherDate( entity.getPublisherDate() );
        eBook.setTranslation( entity.isTranslation() );
        eBook.setUrl( entity.getUrl() );

        return eBook;
    }

    @Override
    public GenreDto toDTO(Genre entity) {
        if ( entity == null ) {
            return null;
        }

        GenreDto genreDto = new GenreDto();

        genreDto.setId( entity.getId() );
        genreDto.setGenre( entity.getGenre() );

        return genreDto;
    }

    @Override
    public Genre fromDto(GenreDto entity) {
        if ( entity == null ) {
            return null;
        }

        Genre genre = new Genre();

        genre.setId( entity.getId() );
        genre.setGenre( entity.getGenre() );

        return genre;
    }

    @Override
    public LanguageDto toDTO(Language entity) {
        if ( entity == null ) {
            return null;
        }

        LanguageDto languageDto = new LanguageDto();

        languageDto.setId( entity.getId() );
        languageDto.setName( entity.getName() );
        languageDto.setIso( entity.getIso() );

        return languageDto;
    }

    @Override
    public Language fromDto(LanguageDto entity) {
        if ( entity == null ) {
            return null;
        }

        Language language = new Language();

        language.setId( entity.getId() );
        language.setName( entity.getName() );
        language.setIso( entity.getIso() );

        return language;
    }

    @Override
    public MagazineDto toDTO(Magazine entity) {
        if ( entity == null ) {
            return null;
        }

        MagazineDto magazineDto = new MagazineDto();

        magazineDto.setId( entity.getId() );
        magazineDto.setTitle( entity.getTitle() );
        magazineDto.setPublisherDate( entity.getPublisherDate() );
        magazineDto.setTranslation( entity.isTranslation() );
        magazineDto.setTotalNumber( entity.getTotalNumber() );
        magazineDto.setBorrowing( entity.getBorrowing() );
        magazineDto.setFreehandArea( entity.getFreehandArea() );
        magazineDto.setSignature( entity.getSignature() );

        return magazineDto;
    }

    @Override
    public Magazine fromDto(MagazineDto entity) {
        if ( entity == null ) {
            return null;
        }

        Magazine magazine = new Magazine();

        magazine.setId( entity.getId() );
        magazine.setTitle( entity.getTitle() );
        magazine.setPublisherDate( entity.getPublisherDate() );
        magazine.setTranslation( entity.isTranslation() );
        magazine.setTotalNumber( entity.getTotalNumber() );
        magazine.setBorrowing( entity.getBorrowing() );
        magazine.setFreehandArea( entity.getFreehandArea() );
        magazine.setSignature( entity.getSignature() );

        return magazine;
    }

    @Override
    public MediaDto toDTO(Media entity) {
        if ( entity == null ) {
            return null;
        }

        MediaDto mediaDto = new MediaDto();

        mediaDto.setId( entity.getId() );
        mediaDto.setTitle( entity.getTitle() );
        mediaDto.setPublisherDate( entity.getPublisherDate() );
        mediaDto.setTranslation( entity.isTranslation() );

        return mediaDto;
    }

    @Override
    public Media fromDto(MediaDto entity) {
        if ( entity == null ) {
            return null;
        }

        Media media = new Media();

        media.setId( entity.getId() );
        media.setTitle( entity.getTitle() );
        media.setPublisherDate( entity.getPublisherDate() );
        media.setTranslation( entity.isTranslation() );

        return media;
    }

    @Override
    public NewspaperDto toDTO(Newspaper entity) {
        if ( entity == null ) {
            return null;
        }

        NewspaperDto newspaperDto = new NewspaperDto();

        newspaperDto.setId( entity.getId() );
        newspaperDto.setTitle( entity.getTitle() );
        newspaperDto.setPublisherDate( entity.getPublisherDate() );
        newspaperDto.setTranslation( entity.isTranslation() );
        newspaperDto.setTotalNumber( entity.getTotalNumber() );
        newspaperDto.setBorrowing( entity.getBorrowing() );
        newspaperDto.setFreehandArea( entity.getFreehandArea() );
        newspaperDto.setSignature( entity.getSignature() );

        return newspaperDto;
    }

    @Override
    public Newspaper fromDto(NewspaperDto entity) {
        if ( entity == null ) {
            return null;
        }

        Newspaper newspaper = new Newspaper();

        newspaper.setId( entity.getId() );
        newspaper.setTitle( entity.getTitle() );
        newspaper.setPublisherDate( entity.getPublisherDate() );
        newspaper.setTranslation( entity.isTranslation() );
        newspaper.setTotalNumber( entity.getTotalNumber() );
        newspaper.setBorrowing( entity.getBorrowing() );
        newspaper.setFreehandArea( entity.getFreehandArea() );
        newspaper.setSignature( entity.getSignature() );

        return newspaper;
    }

    @Override
    public PhysicalMediaDto toDTO(PhysicalMedia entity) {
        if ( entity == null ) {
            return null;
        }

        PhysicalMediaDto physicalMediaDto = new PhysicalMediaDto();

        physicalMediaDto.setId( entity.getId() );
        physicalMediaDto.setTitle( entity.getTitle() );
        physicalMediaDto.setPublisherDate( entity.getPublisherDate() );
        physicalMediaDto.setTranslation( entity.isTranslation() );
        physicalMediaDto.setTotalNumber( entity.getTotalNumber() );
        physicalMediaDto.setBorrowing( entity.getBorrowing() );
        physicalMediaDto.setFreehandArea( entity.getFreehandArea() );
        physicalMediaDto.setSignature( entity.getSignature() );

        return physicalMediaDto;
    }

    @Override
    public PhysicalMedia fromDto(PhysicalMediaDto entity) {
        if ( entity == null ) {
            return null;
        }

        PhysicalMedia physicalMedia = new PhysicalMedia();

        physicalMedia.setId( entity.getId() );
        physicalMedia.setTitle( entity.getTitle() );
        physicalMedia.setPublisherDate( entity.getPublisherDate() );
        physicalMedia.setTranslation( entity.isTranslation() );
        physicalMedia.setTotalNumber( entity.getTotalNumber() );
        physicalMedia.setBorrowing( entity.getBorrowing() );
        physicalMedia.setFreehandArea( entity.getFreehandArea() );
        physicalMedia.setSignature( entity.getSignature() );

        return physicalMedia;
    }

    @Override
    public PublisherDto toDTO(Publisher entity) {
        if ( entity == null ) {
            return null;
        }

        PublisherDto publisherDto = new PublisherDto();

        publisherDto.setId( entity.getId() );
        publisherDto.setName( entity.getName() );

        return publisherDto;
    }

    @Override
    public Publisher fromDto(PublisherDto entity) {
        if ( entity == null ) {
            return null;
        }

        Publisher publisher = new Publisher();

        publisher.setId( entity.getId() );
        publisher.setName( entity.getName() );

        return publisher;
    }

    @Override
    public SinglePhysicalMediaDto toDTO(SinglePhysicalMedia entity) {
        if ( entity == null ) {
            return null;
        }

        SinglePhysicalMediaDto singlePhysicalMediaDto = new SinglePhysicalMediaDto();

        singlePhysicalMediaDto.setId( entity.getId() );
        singlePhysicalMediaDto.setPurchaseDate( entity.getPurchaseDate() );
        singlePhysicalMediaDto.setForSale( entity.getForSale() );

        return singlePhysicalMediaDto;
    }

    @Override
    public SinglePhysicalMedia fromDto(SinglePhysicalMediaDto entity) {
        if ( entity == null ) {
            return null;
        }

        SinglePhysicalMedia singlePhysicalMedia = new SinglePhysicalMedia();

        singlePhysicalMedia.setId( entity.getId() );
        singlePhysicalMedia.setPurchaseDate( entity.getPurchaseDate() );
        singlePhysicalMedia.setForSale( entity.getForSale() );

        return singlePhysicalMedia;
    }

    @Override
    public SpeakerDto toDTO(Speaker entity) {
        if ( entity == null ) {
            return null;
        }

        SpeakerDto speakerDto = new SpeakerDto();

        speakerDto.setId( entity.getId() );
        speakerDto.setName( entity.getName() );

        return speakerDto;
    }

    @Override
    public Speaker fromDto(SpeakerDto entity) {
        if ( entity == null ) {
            return null;
        }

        Speaker speaker = new Speaker();

        speaker.setId( entity.getId() );
        speaker.setName( entity.getName() );

        return speaker;
    }

    @Override
    public TopicDto toDTO(Topic entity) {
        if ( entity == null ) {
            return null;
        }

        TopicDto topicDto = new TopicDto();

        topicDto.setId( entity.getId() );
        topicDto.setName( entity.getName() );

        return topicDto;
    }

    @Override
    public Topic fromDto(TopicDto entity) {
        if ( entity == null ) {
            return null;
        }

        Topic topic = new Topic();

        topic.setId( entity.getId() );
        topic.setName( entity.getName() );

        return topic;
    }
}
