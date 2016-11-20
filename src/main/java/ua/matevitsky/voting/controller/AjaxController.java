package ua.matevitsky.voting.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.matevitsky.voting.LoggedUser;
import ua.matevitsky.voting.model.*;
import ua.matevitsky.voting.repository.LunchRepository;
import ua.matevitsky.voting.repository.MenuRepository;
import ua.matevitsky.voting.repository.UserRepository;
import ua.matevitsky.voting.service.VoteService;
import ua.matevitsky.voting.to.LunchTo;
import ua.matevitsky.voting.to.VoteTo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergey on 25.10.16.
 */

@RestController
@RequestMapping(value = "/ajax/lunches")
public class AjaxController {

    @Autowired
    private LunchRepository lunchRepository;

    @Autowired
    private VoteService voteService;

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private UserRepository userRepository;


    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    List<LunchTo> getLunchList() {

        List<Lunch> lunchList = lunchRepository.findByDate(LocalDate.now());
        List<LunchTo> lunchToList = new ArrayList<>();

        for (Lunch aLunchList : lunchList) {
            LunchTo lunchTo = new LunchTo();
            lunchTo.setRestaurantName(aLunchList.getMenu().getRestaurant().getName());
            lunchTo.setLunchName(aLunchList.getName());
            lunchToList.add(lunchTo);

        }
        return lunchToList;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Restaurant> VoteLunch(@RequestBody LunchTo lunchTo) {
        Menu menu = menuRepository.findByDateAndRestaurantName(LocalDate.now(), lunchTo.getRestaurantName());
        return voteService.save(menu);
    }

    @RequestMapping(value = "/vote", method = RequestMethod.GET)
    public Iterable<Vote> getAllVotes() {
        return voteService.getAllVotes();
    }

    @RequestMapping(value = "/history", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    List<VoteTo> getVoteHistoryForCurrentUser() {

        String loggedUserEmail = userRepository.findOne(LoggedUser.id()).getEmail();
        List<VoteTo> voteHistoryListForCurrentUser = new ArrayList<>();
        Iterable<Vote> voteList = voteService.getAllVotes();
        for (Vote vote : voteList) {
            if (vote.getUser().getEmail().equals(loggedUserEmail)) {
                VoteTo voteTo = new VoteTo();
                voteTo.setDate(vote.getDate());
                voteTo.setRestaurantName(vote.getRestaurant().getName());
                voteHistoryListForCurrentUser.add(voteTo);
            }
        }
        return voteHistoryListForCurrentUser;
    }
}
