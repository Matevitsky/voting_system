package ua.matevitsky.voting.repository;

import sun.util.resources.LocaleData;
import ua.matevitsky.voting.model.Lunch;
import ua.matevitsky.voting.model.Menu;

/**
 * Created by Sergey on 22.09.16.
 */
public interface LunchRepository {

    void deleteLunch(Menu menu, int id);

    Lunch save(Menu menu, Lunch lunch);

    Lunch findByMenu(Menu munu);

    Lunch findByDate(LocaleData data);






}
