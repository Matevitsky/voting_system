package ua.matevitsky.voting.model;

import javax.persistence.*;

/**
 * Created by Sergey on 20.09.16.
 */
@Entity
@Table(name = "users")
public class User extends NamedEntity {

    protected User(Integer id,String name) {
        super(id, name);
    }

    public User() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}