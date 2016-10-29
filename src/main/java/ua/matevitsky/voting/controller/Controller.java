package ua.matevitsky.voting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.matevitsky.voting.model.Menu;
import ua.matevitsky.voting.model.Restaurant;
import ua.matevitsky.voting.service.VoteService;

/**
 * Created by Sergey on 23.09.16.
 */

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class Controller {

    @Autowired
    private VoteService voteService;

    @RequestMapping(value = "vote/{menuId}", method = RequestMethod.POST)
    public ResponseEntity<Restaurant> addVote(@PathVariable("menuId") Menu menu) {
        return voteService.save(menu);
    }

    @RequestMapping(value = "/vote",method = RequestMethod.GET)
    public ResponseEntity<Restaurant> getCurrentVote() {
        return voteService.getCurrentVote();
    }

}
