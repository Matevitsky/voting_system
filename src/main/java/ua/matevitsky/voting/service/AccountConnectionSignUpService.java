package ua.matevitsky.voting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UserProfile;
import ua.matevitsky.voting.model.User;
import ua.matevitsky.voting.repository.UserRepository;

/**
 * Created by Sergey on 18.11.16.
 */

public class AccountConnectionSignUpService implements ConnectionSignUp {

    @Autowired
    private  UserRepository usersDao;

    public AccountConnectionSignUpService(UserRepository usersDao) {
        this.usersDao = usersDao;
    }

    public String execute(Connection<?> connection) {

        UserProfile profile = connection.fetchUserProfile();
        User user = new User();
        user.setName(profile.getName());
        user.setEmail(profile.getEmail());
        usersDao.save(user);
        return profile.getUsername();
    }

}
