package com.ckordes.ShareAndBorrow.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Tool {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private ToolType toolType;
    @NotBlank
    private String name;
    @NotBlank
    @Size(min=10,max = 200, message = "Description must be between 10 and 200 characters!")
    private String description;

    private long userID;

    public Tool() {
    }

    public Tool(ToolType type, String name, String description) {
        this.toolType = type;
        this.name = name;
        this.description = description;
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

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public ToolType getToolType() {
        return toolType;
    }

    public void setToolType(ToolType toolType) {
        this.toolType = toolType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
