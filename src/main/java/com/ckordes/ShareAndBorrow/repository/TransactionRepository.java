package com.ckordes.ShareAndBorrow.repository;

import com.ckordes.ShareAndBorrow.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    Transaction findById(long id);
}
