package ua.matevitsky.voting.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.matevitsky.voting.LoggedUser;
import ua.matevitsky.voting.model.User;
import ua.matevitsky.voting.repository.UserRepository;

/**
 * Created by Sergey on 01.10.16.
 */

@Service("CustomUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    private final Logger log = LoggerFactory.getLogger(UserDetailsService.class);



    @Override
    public LoggedUser loadUserByUsername(final String email) throws UsernameNotFoundException {
        String lowercaseLogin = email.toLowerCase();
        log.debug("Authenticating {}", email);
        User user  = userRepository.findByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException("User " + lowercaseLogin + " was not found in the database");
        }

        return new LoggedUser(user);

    }
}
