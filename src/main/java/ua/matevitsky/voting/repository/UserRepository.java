package ua.matevitsky.voting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.matevitsky.voting.model.User;

/**
 * Created by Sergey on 22.09.16.
 */


@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

    @Transactional(readOnly = true)
    @Query("SELECT u FROM User u WHERE u.id=:id")
    @RequestMapping(method = RequestMethod.GET)
    public User findById(@Param("id") Integer id) ;

    /*@Transactional
    @Modifying*/
        //@Query("DELETE FROM User u WHERE u.id=:id")
    @Override
    void delete( Integer id);

}
