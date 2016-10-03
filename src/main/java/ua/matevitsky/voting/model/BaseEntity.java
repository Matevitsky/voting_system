package ua.matevitsky.voting.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.hateoas.Identifiable;

import javax.persistence.*;

/**
 * Created by Sergey on 20.09.16.
 */

@MappedSuperclass
@Access(AccessType.FIELD)
public class BaseEntity extends AbstractPersistable<Integer> implements Identifiable<Integer> {

  //  public final static int START_SEQ = 100000;

    public BaseEntity() {

    }

    protected BaseEntity(Integer id) {
        setId(id);
    }


    @JsonIgnore
    public boolean isNew() {
        return super.isNew();
    }

}
