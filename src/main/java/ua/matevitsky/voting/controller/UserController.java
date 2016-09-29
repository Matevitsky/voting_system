package ua.matevitsky.voting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.matevitsky.voting.model.Restaurant;
import ua.matevitsky.voting.model.User;
import ua.matevitsky.voting.repository.RestaurantRepository;
import ua.matevitsky.voting.repository.UserRepository;

import java.util.List;

/**
 * Created by Sergey on 23.09.16.
 */

@RestController(value = "users")
public class UserController {

    private UserRepository userRepository;

    private RestaurantRepository restaurantRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }


    @RequestMapping(method = RequestMethod.POST)
    public void addNewWebUser(@Param("name") String name) {
        User user = new User();
        user.setName(name);
        userRepository.save(user);
    }


    @RequestMapping(method = RequestMethod.GET, params = "name")
    public User findById(@Param("id") Integer id) {
        return userRepository.findById(id);
    }


    @RequestMapping(method = RequestMethod.PUT, params = "id")
    public void removeUser(@Param("id") Integer id) {
        userRepository.delete(id);

    }

    public void addRestaurant(@Param("restaurantName") String name) {
        Restaurant restaurant = new Restaurant((name));
        restaurantRepository.save()
    }
}