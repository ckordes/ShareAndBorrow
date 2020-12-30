package com.ckordes.ShareAndBorrow.entity;

import org.hibernate.validator.constraints.pl.PESEL;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue
    private long id;

    @NotBlank
    @Size(min = 2, max = 30, message = "Length of the name must be between 2 and 30 characters.")
    private String firstName;
    @NotBlank
    @Size(min = 2, max = 30, message = "Length of the lastname must be between 2 and 30 characters.")
    private String lastName;
    @Column(nullable = false, unique = true)
    @PESEL
    private String pesel;
    @Column(nullable=false,unique = true)
    @Email
    private String email;
    @NotBlank
    @Size(min = 8, max = 60, message = "Length of the password must be between 8 and 60 characters.")
    private String password;
    @Column(nullable = false, unique = true)
    @NotBlank
    @Size(min = 2, max = 20, message = "Length of the username must be between 2 and 20 characters.")
    private String username;
    @OneToOne
    private Address address;
    @OneToMany (fetch = FetchType.EAGER)
    private List<Tool> tools = new ArrayList<>();
    @ManyToMany (fetch = FetchType.EAGER)
//    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "roles_id"))
    private Set<Role> roles = new HashSet<>();

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String login) {
        this.username = login;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Tool> getTools() {
        return tools;
    }

    public void setTools(List<Tool> tools) {
        this.tools = tools;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    //additional methods
    public String getFullName(){return (this.id + " "+ this.firstName+" "+this.lastName);}
}
