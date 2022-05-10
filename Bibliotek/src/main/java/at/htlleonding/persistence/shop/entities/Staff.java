package at.htlleonding.persistence.shop.entities;

import at.htlleonding.persistence.Media;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Staff extends Customer{
    @Column
    private Integer age;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private Integer salary;
}
