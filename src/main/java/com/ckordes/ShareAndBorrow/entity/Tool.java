package com.ckordes.ShareAndBorrow.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Tool {
    @Id
    @GeneratedValue
    private long id;

    private String type;
    private String name;

    public Tool() {
    }
    public Tool(String type, String name){
        this.type = type;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
