package com.deaddrop.app.model;

import java.sql.Date;
import java.sql.Timestamp;

public class ExecutedTask {
    private int executedId;
    private int taskId;
    private String userName;
    private String title;
    private String description;
    private int credit;
    private Date deadline;
    private Timestamp createdAt;
    private Timestamp startedAt;
    private String director;
    private String imagePath;

    public ExecutedTask(int executedId, int taskId, String userName, String title, String description, int credit, Date deadline, String imagePath, String director, Timestamp createdAt, Timestamp startedAt) {
        this.executedId=executedId;
        this.taskId=taskId;
        this.userName=userName;
        this.title=title;
        this.description=description;
        this.credit=credit;
        this.deadline=deadline;
        this.createdAt=createdAt;
        this.director=director;
        this.imagePath=imagePath;
        this.startedAt=startedAt;
    }

    public int getExecutedId() {
        return executedId;
    }

    public void setExecutedId(int executedId) {
        this.executedId = executedId;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Timestamp getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(Timestamp startedAt) {
        this.startedAt = startedAt;
    }
}
