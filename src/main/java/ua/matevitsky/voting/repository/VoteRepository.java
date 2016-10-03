package ua.matevitsky.voting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.matevitsky.voting.model.Menu;
import ua.matevitsky.voting.model.User;
import ua.matevitsky.voting.model.Vote;

/**
 * Created by Sergey on 26.09.16.
 */


@Repository
public interface VoteRepository extends JpaRepository<Vote,Integer> {


    @Transactional(readOnly = true)
    @Query("SELECT v FROM Vote v WHERE v.user.id=:userid")
    @RequestMapping(method = RequestMethod.GET)
    Vote getVoteByUserId(@Param("userid") Integer userid) ;

}
