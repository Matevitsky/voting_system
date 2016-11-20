package ua.matevitsky.voting.to;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by Sergey on 03.11.16.
 */
public class VoteTo {



    private String restaurantName;

    private LocalDate date;

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getDate() {
        return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
