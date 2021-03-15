package com.ckordes.ShareAndBorrow.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Tool {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    @ManyToOne
    private ToolType toolType;
    @NotBlank
    private String name;

    private long userID;

    public Tool() {
    }

    public Tool(ToolType type, String name) {
        this.toolType = type;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getUserID() { return userID; }

    public void setUserID(long userID) { this.userID = userID; }

    public ToolType getToolType() { return toolType; }

    public void setToolType(ToolType toolType) { this.toolType = toolType; }
}
