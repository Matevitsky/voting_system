package ua.matevitsky.voting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.matevitsky.voting.model.Lunch;
import ua.matevitsky.voting.model.Menu;
import ua.matevitsky.voting.model.Restaurant;

import java.util.List;

/**
 * Created by Sergey on 28.09.16.
 */
@Repository
public interface LunchRepository extends JpaRepository<Lunch, Integer> {



    @Transactional(readOnly = true)
    @Query("SELECT l FROM Lunch l WHERE l.menu=:menu")
    @RequestMapping(method = RequestMethod.GET)
    List<Lunch> findByMenu(@Param("menu") Menu menu) ;
}
