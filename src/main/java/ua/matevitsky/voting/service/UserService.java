package ua.matevitsky.voting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.matevitsky.voting.model.Lunch;
import ua.matevitsky.voting.model.Menu;
import ua.matevitsky.voting.model.Restaurant;
import ua.matevitsky.voting.model.User;
import ua.matevitsky.voting.repository.LunchRepository;
import ua.matevitsky.voting.repository.MenuRepository;
import ua.matevitsky.voting.repository.RestaurantRepository;
import ua.matevitsky.voting.repository.UserRepository;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Sergey on 26.09.16.
 */

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private LunchRepository lunchRepository;


    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    public void addLunch(String name, Integer restaurantId) {
        Restaurant restaurant = restaurantRepository.getOne(restaurantId);
        if (restaurant != null) {
            Lunch lunch = new Lunch();
            lunch.setName(name);
            Menu menu = new Menu();
            menu.setDate(LocalDate.now());
            menu.setRestaurant(restaurant);
            menuRepository.save(menu);
            lunch.setMenu(menu);
            lunchRepository.save(lunch);
            restaurantRepository.save(restaurant);

        } else {
            System.out.println("Restaurant not exist");
        }
    }

    public List <Lunch> getRestaurantMenu(Integer restaurantId) {
        Restaurant restaurant = restaurantRepository.getOne(restaurantId);
        Menu menu = menuRepository.findByRestaurant(restaurant).get(0);
        return lunchRepository.findByMenu(menu);
    }

}
