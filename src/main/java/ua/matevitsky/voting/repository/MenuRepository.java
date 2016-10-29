package ua.matevitsky.voting.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.matevitsky.voting.model.Menu;
import ua.matevitsky.voting.model.Restaurant;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Sergey on 28.09.16.
 */
@Repository
public interface MenuRepository extends CrudRepository<Menu, Integer> {


    @RestResource(path = "by-restaurant")
    @Transactional(readOnly = true)
    @Query("SELECT m FROM Menu m WHERE m.restaurant=:restaurant")
    List<Menu> findByRestaurant(@Param("restaurant") Restaurant restaurant);

    @RestResource(path = "by-date")
    @Transactional(readOnly = true)
    @Query("SELECT m FROM Menu m WHERE m.date=:date")
    List<Menu> findByDate(@Param("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date);


    @Transactional(readOnly = true)
    @Query("SELECT m FROM Menu m WHERE m.date=:date and m.restaurant.name=:restaurantName")
    Menu findByDateAndRestaurantName(@Param("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,@Param("restaurantName") String restaurantName);



}


