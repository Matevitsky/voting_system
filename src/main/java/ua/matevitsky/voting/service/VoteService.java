package ua.matevitsky.voting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.matevitsky.voting.model.Menu;
import ua.matevitsky.voting.model.Vote;
import ua.matevitsky.voting.repository.UserRepository;
import ua.matevitsky.voting.repository.VoteRepository;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Sergey on 26.09.16.
 */

@Service
public class VoteService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VoteRepository voteRepository;

    public void save(Integer userId, Menu menu) {
        LocalDate data = menu.getDate();
        Vote vote = new Vote(userRepository.findById(userId), menu, data);
        voteRepository.save(vote);
    }

    public List<Vote> findAll() {

         return voteRepository.findAll();

    }
}
