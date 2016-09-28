package ua.matevitsky.voting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.matevitsky.voting.model.Menu;
import ua.matevitsky.voting.model.Vote;
import ua.matevitsky.voting.repository.VoteRepository;
import ua.matevitsky.voting.service.VoteService;

import java.util.List;

/**
 * Created by Sergey on 26.09.16.
 */

@RestController
@RequestMapping(value = "vote")
public class VoteController {

    @Autowired
    private VoteService voteService;

    private VoteRepository voteRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Vote> findAllVotes() {
        return voteService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addVote(@Param("userId") Integer userId, @Param("menuId") Menu menu) {

        voteService.save(userId,menu);
    }
}
