package at.htlleonding.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDto {
    @JacksonXmlProperty(isAttribute = true)
    private Integer id;
    @JacksonXmlProperty(isAttribute = true)
    private String firstname;
    @JacksonXmlProperty(isAttribute = true)
    private String lastname;

    private List<Integer> mediaIds = new ArrayList<>();
}
