package at.htlleonding.dto.shop.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StaffDto extends CustomerDto{
    private Integer id;

    private Integer age;

    private String email;

    private Integer salary;

}
