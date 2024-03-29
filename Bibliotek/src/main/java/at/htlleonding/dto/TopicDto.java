package at.htlleonding.dto;

import at.htlleonding.persistence.Media;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TopicDto {
    private Integer id;

    private String name;

    private List<Integer> mediaIds = new ArrayList<>();
}
