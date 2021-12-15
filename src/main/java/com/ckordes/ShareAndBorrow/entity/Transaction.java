package com.ckordes.ShareAndBorrow.entity;

import javax.persistence.*;

@Entity
public class Transaction {
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    private User userOwner;
    @OneToOne
    private User userBorrower;
    private boolean agreedPrice;

    public Transaction() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUserOwner() {
        return userOwner;
    }

    public void setUserOwner(User userOwner) {
        this.userOwner = userOwner;
    }

    public User getUserBorrower() {
        return userBorrower;
    }

    public void setUserBorrower(User userBorrower) {
        this.userBorrower = userBorrower;
    }

    public boolean isAgreedPrice() {
        return agreedPrice;
    }

    public void setAgreedPrice(boolean agreedPrice) {
        this.agreedPrice = agreedPrice;
    }
}
