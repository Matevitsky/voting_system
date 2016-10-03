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
import ua.matevitsky.voting.service.VoteService;

import java.util.List;

/**
 * Created by Sergey on 23.09.16.
 */

@RestController(value = "/api")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private VoteService voteService;


    @RequestMapping(value = "api/users", method = RequestMethod.GET)
    public List<User> findAllUsers() {
        return userService.findAllUsers();
    }


    @RequestMapping(value = "api/users", method = RequestMethod.POST)
    public void addNewWebUser(@Param("name") String name, @Param("email") String email,
                              @Param("password") String password,@Param("enabled") Boolean enabled) {
        userService.addNewUser(name,email,password,enabled);
    }


    @RequestMapping(value = "api/users", method = RequestMethod.GET, params = "id")
    public User findById(@Param("id") Integer id) {
        return userService.findById(id);
    }


    @RequestMapping(value = "api/users", method = RequestMethod.PUT, params = "id")
    public void removeUser(@Param("id") Integer id) {
        userService.removeUser(id);

    }

    @RequestMapping(value = "api/users/restaurant", params = "name", method = RequestMethod.POST)
    public void addRestaurant(@Param("restaurantName") String name) {
        userService.addRestaurant(name);
    }

    @RequestMapping(value = "api/users/restaurant", params = "restaurantId", method = RequestMethod.PUT)
    public void removeRestaurant(@Param("restaurantId") Integer restaurantId) {

        userService.removeRestaurant(restaurantId);
    }

    @RequestMapping(value = "api/restaurant", method = RequestMethod.GET)
    public List<Restaurant> findAllRestaurants() {

        return userService.findAllRestaurants();
    }

    @RequestMapping(value = "api/users/lunch", params = "name", method = RequestMethod.POST)
    public void addLunch(@Param("lunchName") String name, @Param("restaurantId") Integer restaurantId) {
        userService.addLunch(name, restaurantId);
    }

    @RequestMapping(value = "api/restaurant", params = "restaurantId", method = RequestMethod.GET)
    public List<Lunch> getRestaurantMenu(@Param("restaurantId") Integer restaurantId) {
        return userService.getRestaurantMenu(restaurantId);
    }

    @RequestMapping(value = "api/restaurant",method = RequestMethod.POST)
    public void addVote(@Param("userId") Integer userId, @Param("restaurantId") Integer restaurantId) {

        voteService.addVote(userId,restaurantId);
    }
}