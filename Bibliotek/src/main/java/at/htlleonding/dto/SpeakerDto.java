package at.htlleonding.dto;

import at.htlleonding.persistence.AudioBook;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SpeakerDto {
    private Integer id;

    private String name;

    private List<Integer> audioBookIds = new ArrayList<>();
}
