package at.htlleonding.dto;

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
public class AudioBookDto extends DigitalMediaDto{
    private List<Integer> speakerIds = new ArrayList<>();
}
