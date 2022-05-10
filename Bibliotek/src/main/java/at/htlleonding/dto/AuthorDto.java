package at.htlleonding.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDto {
    private Integer id;

    private String firstname;

    private String lastname;

    private List<Integer> mediaIds;
}
