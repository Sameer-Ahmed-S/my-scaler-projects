package com.scaler.springtaskmgr;

import java.util.Date;

public class Task {


    int id;
    String Title;
    String Description;
    Date dueDate;

    public String getTitle() {
        return Title;
    }

    public String getDescription() {
        return Description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public int getId() {
        return id;
    }

    public Task(int id, String title, String description, Date dueDate) {
        this.id = id;
        Title = title;
        Description = description;
        this.dueDate = dueDate;
    }
}
