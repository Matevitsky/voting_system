package ua.matevitsky.voting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.matevitsky.voting.model.Vote;
import ua.matevitsky.voting.repository.RestaurantRepository;
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

    @Autowired
    private RestaurantRepository restaurantRepository;

    public void addVote(Integer userId, Integer restaurantId) {

       /* Vote vote =  voteRepository.getVoteByUserId(userId);
        LocalDateTime before11Time = LocalDateTime.of(LocalDate.now(), LocalTime.of(11,00,00,00));
        if(vote == null || LocalDateTime.now().isBefore(before11Time) ) {
            vote.setRestaurant(restaurantRepository.findById(restaurantId));
            vote.setUser(userRepository.findOne(userId));
            vote.setDate(LocalDate.now());
            voteRepository.save(vote);
        }*/

        Vote vote = new Vote();
        vote = voteRepository.getVoteByUserId(userId);
        LocalDateTime before11Time = LocalDateTime.of(LocalDate.now(), LocalTime.of(11,00,00,00));
        if(vote == null || LocalDateTime.now().isBefore(before11Time) ) {
            vote.setUser(userRepository.findOne(userId));
            vote.setRestaurant(restaurantRepository.findOne(restaurantId));

            vote.setDate(LocalDate.now());
            voteRepository.save(vote);
        }
    }

}
