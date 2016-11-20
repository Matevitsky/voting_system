package ua.matevitsky.voting.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.security.AuthenticationNameUserIdSource;
import ua.matevitsky.voting.repository.UserRepository;
import ua.matevitsky.voting.service.AccountConnectionSignUpService;

import javax.sql.DataSource;

/**
 * Created by Sergey on 18.11.16.
 */

@Configuration
@EnableSocial
@ComponentScan(basePackages = {"ua.matevitsky.voting"})
public class SocialConfig extends SocialConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserRepository usersDao;

    /*@Override
    public void addConnectionFactories(ConnectionFactoryConfigurer connectionFactoryConfigurer, Environment environment) {
        connectionFactoryConfigurer.addConnectionFactory(new FacebookConnectionFactory(
                environment.getProperty("spring.social.facebook.appId"),
                environment.getProperty("spring.social.facebook.appSecret")));
    }*/

    @Override
    public UserIdSource getUserIdSource() {
        return new AuthenticationNameUserIdSource();
    }

    @Override
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
        JdbcUsersConnectionRepository repository = new JdbcUsersConnectionRepository(dataSource,connectionFactoryLocator, Encryptors.noOpText());
        repository.setConnectionSignUp(new AccountConnectionSignUpService(usersDao));
        return repository;
    }


}
