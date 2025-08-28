package com.emidev.auth_server.domain.service;

import com.emidev.auth_server.domain.dto.seguridad.SegRolSimpleDTO;
import com.emidev.auth_server.domain.dto.seguridad.SegUsuarioDTO;
import com.emidev.auth_server.domain.service.seguridad.SegUsuarioService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserDetailService implements UserDetailsService {
    
    private final SegUsuarioService segUsuarioService;

    public UserDetailService(SegUsuarioService segUsuarioService) {
        this.segUsuarioService = segUsuarioService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SegUsuarioDTO byUsername = segUsuarioService.getByUsername(username);
        return new User(
                byUsername.getUsername(),
                byUsername.getPassword(),
                getAuthoritiesEntities(byUsername.getRoles())
        );
    }
    private List<GrantedAuthority> getAuthoritiesEntities(List<SegRolSimpleDTO> userRoles) {
        Set<GrantedAuthority> roles = new HashSet<>();
        userRoles.forEach((role) -> {
            roles.add(new SimpleGrantedAuthority(role.getRol()));
        });

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
        return grantedAuthorities;
    }
}
