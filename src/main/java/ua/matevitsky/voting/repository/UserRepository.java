package ua.matevitsky.voting.repository;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.matevitsky.voting.model.User;

/**
 * Created by Sergey on 22.09.16.
 */


@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @RestResource(path = "by-email")
    @Transactional(readOnly = true)
    @Query("SELECT u FROM User u " +
            " LEFT JOIN u.roles WHERE u.email=:email")
    User findByEmail(@Param("email") String email);

   /* @Override
    User save(User user);*/
}
