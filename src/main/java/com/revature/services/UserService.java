package com.revature.services;


import com.revature.daos.UserDAO;
import com.revature.models.User;

import java.util.ArrayList;

// bridge between controller and DAO
// the service layer contains additional business logic needed to process requests/responses
// it probably wont be doing much here, but it comes into play more with things like login
public class UserService {
    //we need an UserDAO Class so we can call our getUsers() method
    UserDAO uDAO = new UserDAO();


   public ArrayList<User> getUsers(){

       ArrayList<User> users = uDAO.getUsers();

       return users;

    }

}
