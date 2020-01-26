package com.ckordes.ShareAndBorrow.repository;

import com.ckordes.ShareAndBorrow.entity.Address;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository {
    Address findById(long id);
}
