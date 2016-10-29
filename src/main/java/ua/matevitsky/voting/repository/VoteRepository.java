package ua.matevitsky.voting.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.matevitsky.voting.model.Vote;

import java.time.LocalDate;

/**
 * Created by Sergey on 26.09.16.
 */


@RepositoryRestResource(exported = false)
public interface VoteRepository extends CrudRepository<Vote,Integer> {


    @Transactional(readOnly = true)
    @Query("SELECT v FROM Vote v WHERE v.user.id=:userid")
    @RequestMapping(method = RequestMethod.GET)
    Vote getVoteByUserId(@Param("userid") Integer userid) ;

    @Transactional(readOnly = true)
    @Query("SELECT v FROM Vote v WHERE v.user.id=:userId AND v.date=:date")
    Vote getForUserAndDate(@Param("userId") int userId, @Param("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date);


}
