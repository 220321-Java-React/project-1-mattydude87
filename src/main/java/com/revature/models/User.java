package com.revature.models;

public class User {
    private int user_id;
    private String username;
    private String password;
    private String first_name;
    private String last_name;
    private String email;
    private Role role;

    //no args constructor

    public User() {
    }


    // all args constructor

    public User(int user_id, String username, String password, String first_name, String last_name, String email, Role role) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.role = role;
    }

    //We need an "all args minus id" constructor because the id is handled on the database side
    //when inserting data into a database, we should give objects with no id since the database gives each record an id

    public User(String username, String password, String first_name, String last_name, String email, Role role) {
        this.username = username;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.role = role;
    }

    //the toString() method lets us actually print out our objects, since it would print a memory address otherwise

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                '}';
    }

    //getters and setters allow you to access and change your private variables... ENCAPSULATION

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}