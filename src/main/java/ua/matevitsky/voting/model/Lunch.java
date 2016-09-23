package ua.matevitsky.voting.model;

/**
 * Created by Sergey on 22.09.16.
 */
public class Lunch extends NamedEntity {

    protected Lunch(Integer id, String name) {
        super(id, name);
    }

    private Menu menu;

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}