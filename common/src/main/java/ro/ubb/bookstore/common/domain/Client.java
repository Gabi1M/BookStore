package ro.ubb.bookstore.common.domain;

import lombok.*;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
public class Client extends BaseEntity<Long>
{
    private String name;
    private String gender;
    private int age;
}
