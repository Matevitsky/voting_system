package ua.matevitsky.voting.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.matevitsky.voting.model.Restaurant;

/**
 * Created by Sergey on 26.09.16.
 */

@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant,Integer> {

    @Transactional(readOnly = true)
    @Query("SELECT u FROM Restaurant u WHERE u.id=:id")
    @RequestMapping(method = RequestMethod.GET)
    Restaurant findById(@Param("id") Integer id) ;

    @Override
    @Secured("ROLE_ADMIN")
    Restaurant save(Restaurant entity);
}
