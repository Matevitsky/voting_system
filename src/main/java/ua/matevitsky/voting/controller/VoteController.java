package ua.matevitsky.voting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.matevitsky.voting.service.VoteService;

/**
 * Created by Sergey on 26.09.16.
 */

@RestController(value = "/vote")
public class VoteController {

    @Autowired
    private VoteService voteService;




    @RequestMapping(method = RequestMethod.POST)
    public void addVote(@Param("userId") Integer userId, @Param("menuId") Integer menuId) {

        voteService.addVote(userId,menuId);
    }
}
