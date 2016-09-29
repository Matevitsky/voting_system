package ua.matevitsky.voting.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by Sergey on 26.09.16.
 */

@Entity
@Table(name = "votes", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "vote_date"}, name = "unique_vote")})
public class Vote extends BaseEntity implements Serializable{

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @NotNull
    private User user;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "menu_id", nullable = false)
    @NotNull
    private Menu menu;

    @NotNull
    @Column(name = "vote_date", nullable = false,columnDefinition = "Date")
     private LocalDate date;

    public Vote(User user, Menu menu, LocalDate date) {
        this.user = user;
        this.menu = menu;
        this.date = date;
    }

    public Vote() {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "user=" + user +
                ", menu=" + menu +
                ", date=" + date +
                '}';
    }
}
