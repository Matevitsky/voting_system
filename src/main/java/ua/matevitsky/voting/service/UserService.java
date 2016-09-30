package ua.matevitsky.voting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.matevitsky.voting.model.*;
import ua.matevitsky.voting.repository.*;

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


    public List<User> findAllUsers() {
        return userRepository.findAll();
    }



    public void addNewUser(String name) {
        User user = new User();
        user.setName(name);
        userRepository.save(user);
    }

    public User findById(Integer id) {
        return userRepository.findById(id);
    }

    public void removeUser(Integer id) {
        userRepository.delete(id);

    }

    public void addRestaurant(String name) {
        Restaurant restaurant = new Restaurant();
        restaurant.setName(name);
        restaurantRepository.save(restaurant);
    }

    public void removeRestaurant(Integer restaurantId) {

        restaurantRepository.delete(restaurantId);
    }

    public List<Restaurant> findAllRestaurants() {

        return restaurantRepository.findAll();
    }

    public void addLunch(String name, Integer restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId);
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
        Restaurant restaurant = restaurantRepository.findById(restaurantId);
        Menu menu = menuRepository.findByRestaurant(restaurant).get(0);
        return lunchRepository.findByMenu(menu);
    }

}
