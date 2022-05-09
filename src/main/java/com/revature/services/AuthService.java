package com.revature.services;

import com.revature.daos.AuthDAO;
import com.revature.daos.UserDAO;
import com.revature.models.User;

// semi hardcoding here. youll need to get this user data from the DAO & DB
public class AuthService {
    AuthDAO aDAO = new AuthDAO();
    // typically youll want to validate username/password here in the service
    // by calling some DAO method that gets users where username = ? and password = ?

    public User login(String username, String password) {
        return aDAO.isValidUser(username, password);
    }
}





