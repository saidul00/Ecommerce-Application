package dev.saidul.EcomUserAuthService.security.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import dev.saidul.EcomUserAuthService.entity.Role;
import dev.saidul.EcomUserAuthService.entity.User;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@JsonDeserialize
@NoArgsConstructor
public class CustomUserDetails implements UserDetails {


    private List<GrantedAuthority> authorities;
    private String password;
    private String username;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;



    public CustomUserDetails(User user) {

//        this.user = user;
        authorities = new ArrayList<>();

        for (Role role: user.getRoles()) {
            authorities.add(new CustomGrantedAuthority(role));
        }

        this.password = user.getPassword();
        this.username = user.getEmail();
        this.accountNonExpired = true;
        this.accountNonLocked = true;
        this.credentialsNonExpired = true;
        this.enabled = true;

    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<CustomGrantedAuthority> customGrantedAuthorities = new ArrayList<>();
//
//        for (Role role: user.getRoles()) {
//            customGrantedAuthorities.add(new CustomGrantedAuthority(role));
//        }
//
//        return customGrantedAuthorities;
        return this.authorities;
    }

    @Override
    public String getPassword() {
//        return user.getPassword();
        return this.password;
    }

    @Override
    public String getUsername() {
//        return user.getEmail();
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
//        return true;
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
//        return true;
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
//        return true; // if (Date.now() - lastPasswordUpdateDate > 90) {return false} return true;
        return this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
//        return true;
        return this.enabled;
    }
}
