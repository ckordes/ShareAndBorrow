package com.ckordes.ShareAndBorrow.entity;

import javax.persistence.*;

@Entity
public class Transaction {
    @Id
    @GeneratedValue
    private long id;
    @OneToOne
    private Person personOwner;
    @OneToOne
    private Person personBorrower;
    private boolean agreedPrice;

    public Transaction() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Person getPersonOwner() {
        return personOwner;
    }

    public void setPersonOwner(Person personOwner) {
        this.personOwner = personOwner;
    }

    public Person getPersonBorrower() {
        return personBorrower;
    }

    public void setPersonBorrower(Person personBorrower) {
        this.personBorrower = personBorrower;
    }

    public boolean isAgreedPrice() {
        return agreedPrice;
    }

    public void setAgreedPrice(boolean agreedPrice) {
        this.agreedPrice = agreedPrice;
    }
}
