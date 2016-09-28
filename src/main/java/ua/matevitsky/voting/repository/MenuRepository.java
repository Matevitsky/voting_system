package ua.matevitsky.voting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.matevitsky.voting.model.Menu;

/**
 * Created by Sergey on 28.09.16.
 */
public interface MenuRepository extends JpaRepository<Menu, Integer> {
}
