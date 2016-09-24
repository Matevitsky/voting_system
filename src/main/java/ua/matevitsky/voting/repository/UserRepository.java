package ua.matevitsky.voting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.matevitsky.voting.model.User;

/**
 * Created by Sergey on 22.09.16.
 */


@Repository
public interface UserRepository extends JpaRepository<User,Long>{

}
