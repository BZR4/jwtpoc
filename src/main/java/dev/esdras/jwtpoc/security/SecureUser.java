package dev.esdras.jwtpoc.security;

import dev.esdras.jwtpoc.model.enums.Profile;
import dev.esdras.jwtpoc.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class SecureUser implements UserDetails {

    private Long id;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    @Autowired
    private ClienteService clienteService;

    public SecureUser(Long id, String email, String password, Set<Profile> profiles) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.authorities = profiles.stream().map(p -> new SimpleGrantedAuthority(p.getDescription())).collect(Collectors.toSet());
    }

    public SecureUser() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    public Long getId() {
        return id;
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
}
