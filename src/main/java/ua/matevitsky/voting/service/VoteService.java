package ua.matevitsky.voting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ua.matevitsky.voting.LoggedUser;
import ua.matevitsky.voting.model.Menu;
import ua.matevitsky.voting.model.Restaurant;
import ua.matevitsky.voting.model.Vote;
import ua.matevitsky.voting.repository.UserRepository;
import ua.matevitsky.voting.repository.VoteRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Created by Sergey on 30.09.16.
 */
@Service
public class VoteService {

    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private UserRepository userRepository;


    public ResponseEntity<Restaurant> save(Menu menu) {
        LocalDate today = LocalDate.now();
        if (menu == null || !menu.getDate().equals(today)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Vote vote = new Vote();
        vote.setUser(userRepository.findOne(LoggedUser.id()));
        vote.setRestaurant(menu.getRestaurant());
        vote.setDate(today);
        LocalDateTime before11Time = LocalDateTime.of(LocalDate.now(), LocalTime.of(11, 00, 00, 00));

        if (LocalDateTime.now().isBefore(before11Time)) {
            if (voteRepository.getForUserAndDate(LoggedUser.id(), today) == null) {
                voteRepository.save(vote);
                return new ResponseEntity<>(HttpStatus.CREATED);
            } else {

                vote = voteRepository.getForUserAndDate(LoggedUser.id(), today);
                vote.setRestaurant(menu.getRestaurant());
                voteRepository.save(vote);
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);


    }

    public ResponseEntity<Restaurant> getCurrentVote() {
        Vote vote = voteRepository.getForUserAndDate(LoggedUser.id(), LocalDate.now());

        if (vote != null) {
            return new ResponseEntity<>(vote.getRestaurant(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}