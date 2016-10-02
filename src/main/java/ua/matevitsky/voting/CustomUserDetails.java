package ua.matevitsky.voting;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;
import ua.matevitsky.voting.model.Role;
import ua.matevitsky.voting.model.User;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Sergey on 01.10.16.
 */
public class CustomUserDetails extends User implements UserDetails {
    private static final long serialVersionUID = 1L;
    private List<String> userRoles;


    public CustomUserDetails(User user) {
        super(user);
        this.userRoles = Stream.of(Role.values())
                .map(Enum::name)
                .collect(Collectors.toList());
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        String roles = StringUtils.collectionToCommaDelimitedString(userRoles);
        return AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
    }


    @Override


    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }


    @Override


    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override


    public boolean isEnabled() {
        return true;
    }


    @Override


    public String getUsername() {
        return super.getName();
    }


}