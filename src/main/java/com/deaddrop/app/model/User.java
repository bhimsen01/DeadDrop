package com.deaddrop.app.model;

public class User {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private int credit;

    public User(String firstName, String lastName, String userName, String password){
        this.firstName=firstName;
        this.lastName=lastName;
        this.userName=userName;
        this.password=password;
    }

    public User(String firstName, String lastName, String userName, String password, int credit){
        this.firstName=firstName;
        this.lastName=lastName;
        this.userName=userName;
        this.password=password;
        this.credit=credit;
    }

    public String getFirstName(){return firstName;};
    public void setFirstName(String firstName){this.firstName=firstName;};

    public String getLastName(){return lastName;};
    public void setLastName(String lastName){this.lastName=lastName;};

    public String getUserName(){return userName;};
    public void setUserName(String userName){this.userName=userName;};

    public String getPassword(){return password;};
    public void setPassword(String password){this.password=password;};

    public int getCredit(){return credit;};
    public void setCredit(int credit){this.credit=credit;};
}

