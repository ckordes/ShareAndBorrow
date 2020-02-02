package com.ckordes.ShareAndBorrow.service;

import com.ckordes.ShareAndBorrow.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class SpringDataUserDetailsService  implements UserDetailsService {
    private UserService userService;
    @Autowired
    public void setUserRepository(UserService userService) {
        this.userService = userService;
    }
    @Override
    public UserDetails loadUserByUsername(String email) {
        Person person = userService.findPersonByEmail(email);
        if (person == null) {throw new UsernameNotFoundException(email); }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        person.getRoles().forEach(r ->
                grantedAuthorities.add(new SimpleGrantedAuthority(r.getName())));
        return new org.springframework.security.core.userdetails.User(
                person.getEmail(), person.getPassword(), grantedAuthorities);
    }
}
