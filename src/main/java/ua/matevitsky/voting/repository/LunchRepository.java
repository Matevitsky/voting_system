package ua.matevitsky.voting.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.matevitsky.voting.model.Lunch;
import ua.matevitsky.voting.model.Menu;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Sergey on 28.09.16.
 */
@Repository
public interface LunchRepository extends CrudRepository<Lunch, Integer> {



    @RestResource(path = "by-menu")
    @Transactional(readOnly = true)
    @Query("SELECT l FROM Lunch l WHERE l.menu=:menu")
    List<Lunch> findByMenu(@Param("menu") Menu menu) ;

    @RestResource(path = "by-date")
    @Transactional(readOnly = true)
    @Query("SELECT l FROM Lunch l WHERE l.menu.date=:date")
    List<Lunch> findByDate(@Param("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date);



}
