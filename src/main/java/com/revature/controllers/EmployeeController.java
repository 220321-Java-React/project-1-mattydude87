package com.revature.controllers;

// controller layer is where HTTP requests get sent after javalin directs them
// its in this layer that we'll parse any JSON into Java objects and vice versa
// well either be getting data from the service layer (which gets the data from the DAO)
// OR well be sending data that came from the webpage to the service layer (which sends the data to the DAO)

import com.google.gson.Gson;
import com.revature.models.Employee;
import com.revature.services.EmployeeService;
import io.javalin.http.Handler;

import java.util.ArrayList;

public class EmployeeController {

    // we need an EmployeeService object
    EmployeeService es = new EmployeeService();

    // this handler will get the http get request for all employees, and send back the employees from the database
    public Handler getEmployeesHandler = (ctx) -> {

        // we need an arraylist of employee objects (which well get from the service layer)
        ArrayList<Employee> employees = es.getEmployees();
        // the dao is going to return an array list of employee objects if we call the right method

        //create a GSON object to convert our Java object into JSON since (since we can only transfer JSON, not Java)
        Gson gson = new Gson();

        //use the JSON .toJson() method to turn our Java into JSON
        String JSONEmployees = gson.toJson(employees);

        //Give a response containing our JSON string back to the webpage (wherever the HTTP request came from)
        ctx.result(JSONEmployees); //.result() sends a response of data back
        ctx.status(200); //.status() sets the HTTP status code. 200 stands for "OK"
    };
}
