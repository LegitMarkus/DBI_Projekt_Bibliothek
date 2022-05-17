package at.htlleonding.dto;

import at.htlleonding.persistence.shop.entities.LendingKey;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DigitalMediaDto extends MediaDto{
    private String url;

    private List<Integer> lendingIds = new LinkedList<>();
}
