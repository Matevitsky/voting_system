package ua.matevitsky.voting.model;

/**
 * Created by Sergey on 20.09.16.
 */


public class NamedEntity extends BaseEntity{

    private String name;

    protected NamedEntity(Integer id, String name) {
        super(id);
        this.name = name;

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
