package at.htlleonding.dto.xml;

import at.htlleonding.dto.AuthorDto;
import at.htlleonding.dto.MediaDto;
import at.htlleonding.dto.PublisherDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonRootName("WorksOfAuthor")
public class WorksOfAuthorDto {
    @JsonProperty("Author")
    AuthorDto author;

    @JacksonXmlElementWrapper(localName = "Works")
    @JsonProperty("Work")
    List<MediaDto> work = new ArrayList<MediaDto>();

    @JacksonXmlElementWrapper(localName = "Publications")
    @JsonProperty("Publication")
    List<PublisherDto> publication = new ArrayList<>();
}
