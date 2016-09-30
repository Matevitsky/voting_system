package ua.matevitsky.voting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.matevitsky.voting.model.Lunch;
import ua.matevitsky.voting.model.Restaurant;
import ua.matevitsky.voting.model.User;
import ua.matevitsky.voting.service.UserService;

import java.util.List;

/**
 * Created by Sergey on 23.09.16.
 */

@RestController(value = "/")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> findAllUsers() {
        return userService.findAllUsers();
    }


    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public void addNewWebUser(@Param("name") String name) {
        userService.addNewUser(name);
    }


    @RequestMapping(value = "/users", method = RequestMethod.GET, params = "name")
    public User findById(@Param("id") Integer id) {
        return userService.findById(id);
    }


    @RequestMapping(value = "/users", method = RequestMethod.PUT, params = "id")
    public void removeUser(@Param("id") Integer id) {
        userService.removeUser(id);

    }

    @RequestMapping(value = "/restaurant", params = "name", method = RequestMethod.POST)
    public void addRestaurant(@Param("restaurantName") String name) {
        userService.addRestaurant(name);
    }

    @RequestMapping(value = "/restaurant", params = "restaurantId", method = RequestMethod.PUT)
    public void removeRestaurant(@Param("restaurantId") Integer restaurantId) {

        userService.removeRestaurant(restaurantId);
    }

    @RequestMapping(value = "/restaurant", method = RequestMethod.GET)
    public List<Restaurant> findAllRestaurants() {

        return userService.findAllRestaurants();
    }

    @RequestMapping(value = "/lunch", params = "name", method = RequestMethod.POST)
    public void addLunch(@Param("lunchName") String name, @Param("restaurantId") Integer restaurantId) {
        userService.addLunch(name, restaurantId);
    }

    @RequestMapping(value = "/restaurant/menu", params = "restaurantId", method = RequestMethod.GET)
    public List<Lunch> getRestaurantMenu(@Param("restaurantId") Integer restaurantId) {
        return userService.getRestaurantMenu(restaurantId);
    }
}