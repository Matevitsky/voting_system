package ua.matevitsky.voting.model;



/**
 * Created by Sergey on 22.09.16.
 */
import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "lunch")
public class Lunch extends NamedEntity {

    public Lunch( String name,Integer id) {
        super(id, name);
    }

    public Lunch(){

    }

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "menu_id", nullable = false)
    @NotNull
    private Menu menu;

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    @Override
    public String toString() {
        return "Lunch{" +
                "menu=" + menu +
                '}';
    }
}