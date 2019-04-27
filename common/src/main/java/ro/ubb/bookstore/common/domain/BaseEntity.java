package ro.ubb.bookstore.common.domain;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
@NoArgsConstructor
@Data
@ToString
public class BaseEntity<ID> implements Serializable
{
    @Id
    @GeneratedValue
    private ID id;
}
