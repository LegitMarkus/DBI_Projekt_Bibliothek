package at.htlleonding.dto;

import at.htlleonding.persistence.Media;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PublisherDto {
    @JacksonXmlProperty(isAttribute = true)
    private Integer id;

    @JacksonXmlProperty(isAttribute = true)
    private String name;

    private List<Integer> mediaIds = new ArrayList<>();
}
