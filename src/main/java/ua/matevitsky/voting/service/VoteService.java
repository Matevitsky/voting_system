package ua.matevitsky.voting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.matevitsky.voting.model.Vote;
import ua.matevitsky.voting.repository.RestaurantRepository;
import ua.matevitsky.voting.repository.UserRepository;
import ua.matevitsky.voting.repository.VoteRepository;

import java.time.LocalDate;

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
        Vote vote = new Vote();
        vote.setRestaurant(restaurantRepository.findById(restaurantId));
        vote.setUser(userRepository.findOne(userId));
        vote.setDate(LocalDate.now());
        voteRepository.save(vote);
    }
}
