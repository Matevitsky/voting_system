package ua.matevitsky.voting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.matevitsky.voting.model.Menu;
import ua.matevitsky.voting.model.Restaurant;
import ua.matevitsky.voting.service.UserService;
import ua.matevitsky.voting.service.VoteService;

/**
 * Created by Sergey on 23.09.16.
 */

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private VoteService voteService;


    @RequestMapping(value = "vote/{menuId}", method = RequestMethod.POST)
    public ResponseEntity<Restaurant> addVote(@PathVariable("menuId") Menu menu) {
        return voteService.save(menu);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Restaurant> getCurrentVote() {
        return voteService.getCurrentVote();
    }



   /* @RequestMapping(value = "api/users", method = RequestMethod.GET)
    public User findUserByEmail(@Param("email") String email) {
        return userService.findUserByEmail(email);
    }*/
}


   /* @RequestMapping(value = "api/users", method = RequestMethod.GET, params = "id")
    public User findById(@Param("id") Integer id) {
        return userService.findById(id);
    }
    @RequestMapping(value = "api/users", method = RequestMethod.GET, params = "email")
    public User findByEmail(@Param("email") String email) {
        return userService.findByEmail(email);
    }*/


   /* @RequestMapping(value = "api/restaurants", params = "name", method = RequestMethod.POST)
    public void addRestaurant(@Param("restaurantName") String name) {
        userService.addRestaurant(name);
    }
*/
   /* @RequestMapping(value = "api/users/restaurant", params = "restaurantId", method = RequestMethod.PUT)
    public void removeRestaurant(@Param("restaurantId") Integer restaurantId) {

        userService.removeRestaurant(restaurantId);
    }*/

  /*  @RequestMapping(value = "api/restaurant", method = RequestMethod.GET)
    public List<Restaurant> findAllRestaurants() {

        return userService.findAllRestaurants();
    }*/

   /* @RequestMapping(value = "api/users/lunch", params = "name", method = RequestMethod.POST)
    public void addLunch(@Param("lunchName") String name, @Param("restaurantId") Integer restaurantId) {
        userService.addLunch(name, restaurantId);
    }*/

   /* @RequestMapping(value = "api/restaurant", params = "restaurantId", method = RequestMethod.GET)
    public List<Lunch> getRestaurantMenu(@Param("restaurantId") Integer restaurantId) {
        return userService.getRestaurantMenu(restaurantId);
    }*/

   /* @RequestMapping(value = "/{id}",method = RequestMethod.POST)
    public void addVote(@Param("userId") Integer userId, @Param("restaurantId") Integer restaurantId) {

        voteService.addVote(userId,restaurantId);
    }*/


//}