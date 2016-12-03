package com.example.ba.boxappandroid;

import java.io.Serializable;

/**
 * Created by 2096904 on 12/3/16.
 */
public class Task implements Serializable {

    private String description;

    private int priority;

    public Task() {
    }

    public Task(String description, int priority) {
        this.description = description;
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

}
