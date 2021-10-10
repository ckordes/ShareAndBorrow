package com.ckordes.ShareAndBorrow.repository;

import com.ckordes.ShareAndBorrow.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findById(long id);
    User findByEmail(String email);
    User findByUsername(String username);
//    @Query("select u from User u where u.address.postalCode = ?1")
//    List<User> findByAddress_PostalCode(String postalCode);
}
