package ua.matevitsky.voting.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Created by Sergey on 20.09.16.
 */

@MappedSuperclass
public class NamedEntity extends BaseEntity{


    @Column(name = "name")
    @NotEmpty
    protected String name;



    protected NamedEntity(Integer id, String name) {
        super(id);
        this.name = name;

    }

    public NamedEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "NamedEntity{" +
                "name='" + name + '\'' +
                '}';
    }
}
