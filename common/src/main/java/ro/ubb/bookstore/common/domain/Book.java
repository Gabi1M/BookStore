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
public class Book extends BaseEntity<Long>
{
    private String title;
    private String author;
    private String genre;
    private int year;
}
