package ua.matevitsky.voting.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Created by Sergey on 20.09.16.
 */

@Entity
@Table(name = "restaurants", uniqueConstraints = {@UniqueConstraint(columnNames = "name", name = "unique_restaurant")})
public class Restaurant  extends NamedEntity{



    public Restaurant() {
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
