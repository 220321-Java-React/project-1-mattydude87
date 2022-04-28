package com.revature.models;

public class Employee {
    private int employee_id;
    private String first_name;
    private String last_name;
    private Role role;

    //no args constructor
    public Employee() {
        super();
    }

    // all args constructor
    public Employee(int employee_id, String first_name, String last_name, Role role) {
        this.employee_id = employee_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.role = role;
    }

    //We need an "all args minus id" constructor because the id is handled on the database side
    //when inserting data into a database, we should give objects with no id since the database gives each record an id
    public Employee(String first_name, String last_name, Role role) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.role = role;
    }
    //the toString() method lets us actually print out our objects, since it would print a memory address otherwise
    @Override
    public String toString() {
        return "Employee{" + "employee_id=" + employee_id + ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' + ", role=" + role + '}';
    }

    //getters and setters allow you to access and change your private variables... ENCAPSULATION

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
