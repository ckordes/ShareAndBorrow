package com.ckordes.ShareAndBorrow.service;

import com.ckordes.ShareAndBorrow.entity.Person;
import com.ckordes.ShareAndBorrow.entity.Role;
import com.ckordes.ShareAndBorrow.repository.PersonRepository;
import com.ckordes.ShareAndBorrow.repository.RoleRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {
    private final PersonRepository personRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    public UserServiceImpl(PersonRepository personRepository, RoleRepository roleRepository,
                           BCryptPasswordEncoder passwordEncoder) {
        this.personRepository = personRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @Override
    public Person findPersonByEmail(String email) {
        return personRepository.findByEmail(email);
    }
    @Override
    public void saveUser(Person person) {
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        Role personRole = roleRepository.findByName("ROLE_USER");
        person.setRoles(new HashSet<Role>(Arrays.asList(personRole)));
        personRepository.save(person);
    }

}
