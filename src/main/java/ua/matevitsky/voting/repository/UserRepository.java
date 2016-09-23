package ua.matevitsky.voting.repository;

import ua.matevitsky.voting.model.User;

import java.util.List;

/**
 * Created by Sergey on 22.09.16.
 */
public interface UserRepository  {

    List<User> getAllRestaurant();

    User get(int id);

    User save(User user);

    //false if not found
    boolean delete(int id);
}
