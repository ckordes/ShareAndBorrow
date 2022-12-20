package com.ckordes.ShareAndBorrow.repository;

import com.ckordes.ShareAndBorrow.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    Address findById(long id);
    Address findByUserName(String userName);
}
