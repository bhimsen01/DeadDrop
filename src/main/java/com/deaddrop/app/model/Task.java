package com.deaddrop.app.model;

import java.sql.Timestamp;
import java.util.Date;

public class Task {
    private int taskId;
    private String title;
    private String description;
    private String imagePath;
    private int credits;
    private Date deadline;
    private Timestamp createdAt;
    private String director;

    public Task(int taskId, String title, String description, String imagePath, int credits, Date deadline, Timestamp createdAt, String director){
        this.taskId=taskId;
        this.title=title;
        this.description=description;
        this.imagePath=imagePath;
        this.credits=credits;
        this.deadline=deadline;
        this.createdAt=createdAt;
        this.director=director;
    }

    public Task(String title, String description, String imagePath, int credits, Date deadline, Timestamp createdAt, String director){
        this.title=title;
        this.description=description;
        this.imagePath=imagePath;
        this.credits=credits;
        this.deadline=deadline;
        this.createdAt=createdAt;
        this.director=director;
    }

    public int getTaskId(){return taskId;};
    public void setTaskId(int taskId){this.taskId=taskId;};

    public String getTitle(){return title;};
    public void setTitle(String title){this.title=title;};

    public String getDescription(){return description;};
    public void setDescription(String description){this.description=description;};

    public String getImagePath(){return imagePath;};
    public void setImagePath(String imagePath){this.imagePath=imagePath;};

    public int getCredits(){return credits;};
    public void setCredits(int credits){this.credits = credits;};

    public Date getDeadline(){return deadline;};
    public void setDeadline(Date deadline){this.deadline=deadline;};

    public Timestamp getCreatedAt(){return createdAt;};
    public void setCreatedAt(Timestamp createdAt){this.createdAt=createdAt;};

    public String getDirector(){return director;};
    public void setDirector(String director){this.director=director;};
}
