package ua.matevitsky.voting.model;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by Sergey on 01.10.16.
 */


public enum  Role implements GrantedAuthority{
    ROLE_USER,
    ROLE_ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }


}
