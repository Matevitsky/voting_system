package ua.matevitsky.voting.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * Created by Sergey on 20.09.16.
 */

@Entity
@Table(name = "menu", uniqueConstraints = {@UniqueConstraint(columnNames = {"menu_date", "restaurant_id"}, name = "unique_menu")})
public class Menu extends BaseEntity {

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @NotNull
    private Restaurant restaurant;

    @NotNull
    @Column(name = "menu_date", nullable = false)
    private LocalDate date;

    public Menu(Integer id, Restaurant restaurant,LocalDate  date) {
        super(id);
        this.restaurant = restaurant;
        this.date = date;
    }
    public Menu(){

    }

    @Override
    public String toString() {
        return "Menu{" +
                "restaurant=" + restaurant +
                ", date=" + date +
                '}';
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
