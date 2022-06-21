package at.htlleonding.dto;

import at.htlleonding.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonRootName("Work")
public class MediaDto {
    private Integer id;
    @JsonProperty("Title")
    private String title;
    @JsonProperty("PublisherDate")
    private Date publisherDate;

    private Integer publisherId;
    @JsonProperty("Translation")
    private boolean translation;

    private Integer languageId;

    private List<Integer> topicIds = new ArrayList<>();

    private Integer genreId;

    private List<Integer> authorIds = new ArrayList<>();
}
