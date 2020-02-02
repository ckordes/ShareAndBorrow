package com.ckordes.ShareAndBorrow.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Price {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    private Transaction transaction;
    private BigDecimal price;

    public Price() {
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
