package at.htlleonding.dto;

import at.htlleonding.persistence.*;
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
public class MediaDto {
    private Integer id;

    private String title;

    private Date publisherDate;

    private Integer publisherId;

    private boolean translation;

    private Integer languageId;

    private List<Integer> topicIds = new ArrayList<>();

    private Integer genreId;

    private List<Integer> authorIds = new ArrayList<>();
}
