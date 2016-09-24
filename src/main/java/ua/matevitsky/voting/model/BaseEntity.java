package ua.matevitsky.voting.model;

import javax.persistence.Id;

/**
 * Created by Sergey on 20.09.16.
 */


public class BaseEntity  {

    @Id
    private Integer id;

    protected BaseEntity(Integer id) {
        this.id = id;
    }


}
