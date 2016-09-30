package ua.matevitsky.voting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.matevitsky.voting.model.Vote;
import ua.matevitsky.voting.repository.MenuRepository;
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
    private MenuRepository menuRepository;

    public void addVote(Integer userId, Integer menuId) {
        Vote vote = new Vote();
        vote.setMenu(menuRepository.findOne(menuId));
        vote.setUser(userRepository.findById(userId));
        vote.setDate(LocalDate.now());
        voteRepository.save(vote);
    }
}
