package ua.matevitsky.voting.model;


import java.time.LocalDate;

/**
 * Created by Sergey on 20.09.16.
 */
public class Menu extends BaseEntity {

    private Restaurant restaurant;
    private LocalDate  date;

    public Menu(Integer id, Restaurant restaurant,LocalDate  date) {
        super(id);
        this.restaurant = restaurant;
        this.date = date;
    }
}
