package ua.matevitsky.voting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.matevitsky.voting.repository.RestaurantRepository;
import ua.matevitsky.voting.repository.UserRepository;

/**
 * Created by Sergey on 07.10.16.
 */



@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @RequestMapping("/")
    String login(){
        return "login";
    }

    @RequestMapping("/users")
    String getUsers(){
        return "usersList";
    }

    @RequestMapping("/lunchList")
    String getLunchList(){
        return "lunchList";
    }
}
