package ua.matevitsky.voting.repository;

import sun.util.resources.LocaleData;
import ua.matevitsky.voting.model.Menu;
import ua.matevitsky.voting.model.Restaurant;

import java.util.List;

/**
 * Created by Sergey on 22.09.16.
 */
public interface MenuRepository {

    List<Menu> findByRestaurant(Restaurant restaurant);

    Menu findRestaurantByDate(Restaurant restaurant, LocaleData data);

    Menu saveRestaurant(Restaurant restaurant);

    void delete(Integer id);

}
