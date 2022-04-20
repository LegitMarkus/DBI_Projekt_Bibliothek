package at.htlleonding.dto;

import at.htlleonding.persistence.AudioBook;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SpeakerDto {
    private Integer id;

    private String name;

    private List<Integer> audioBookIds;
}
