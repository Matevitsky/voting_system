package ua.matevitsky.voting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.matevitsky.voting.model.Lunch;

/**
 * Created by Sergey on 28.09.16.
 */
public interface LunchRepository extends JpaRepository<Lunch, Integer> {
}
