package at.htlleonding.dto;

import at.htlleonding.persistence.Author;
import at.htlleonding.persistence.SinglePhysicalMedia;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PhysicalMediaDto extends MediaDto{

    private Integer totalNumber;

    private Integer borrowing;

    private Integer freehandArea;

    private String Signature;

    private List<Integer> singlePhysicalMediaIds;
}
