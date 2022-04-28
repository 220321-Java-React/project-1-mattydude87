package com.revature.services;


import com.revature.daos.EmployeeDAO;
import com.revature.models.Employee;

import java.util.ArrayList;

// bridge between controller and DAO
// the service layer contains additional business logic needed to process requests/responses
// it probably wont be doing much here, but it comes into play more with things like login
public class EmployeeService {
    //we need an EmployeeDAO Class so we can call our getEmployees() method.
    EmployeeDAO eDAO = new EmployeeDAO();

    //this method gets all employees from the DAO (we will call this method from the Handler in the controller layer).
   public ArrayList<Employee> getEmployees(){

       //get the list of employees from the DAO
       ArrayList<Employee> employees = eDAO.getEmployees();

       //return that list of employees
       return employees;

    }


}
