package ua.matevitsky.voting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.matevitsky.voting.model.Vote;

/**
 * Created by Sergey on 26.09.16.
 */


@Repository
public interface VoteRepository extends JpaRepository<Vote,Integer> {

}
