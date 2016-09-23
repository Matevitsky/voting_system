package ua.matevitsky.voting.repository;

import ua.matevitsky.voting.model.Restaurant;

import java.util.List;

/**
 * Created by Sergey on 22.09.16.
 */
public interface RestaurantRepository {

    List<Restaurant> getAllRestaurant();

    Restaurant save(Restaurant restaurant);

    boolean delete(int id);

    Restaurant get(int id);


}
