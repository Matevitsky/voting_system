package ua.matevitsky.voting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Sergey on 07.10.16.
 */



@Controller
public class LoginController {

    @RequestMapping("/")
    String login(){
        return "login";
    }

    @RequestMapping("/userTemplate")
    String loginPage(){
        return "userTemplate";
    }

    @RequestMapping("/users")
    String getUsers(){
        return "usersList";
    }

    @RequestMapping("/history")
    String getLunchList(){
        return "voteHistoryForCurrentUser";
    }
}
