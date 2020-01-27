package com.ckordes.ShareAndBorrow.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Transaction {
    @Id
    @GeneratedValue
    private long id;

    private Price price;
    private boolean agreedPrice;
    private Person personOwner;
    private Person personBorrower;

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

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public boolean isAgreedPrice() {
        return agreedPrice;
    }

    public void setAgreedPrice(boolean agreedPrice) {
        this.agreedPrice = agreedPrice;
    }
}
