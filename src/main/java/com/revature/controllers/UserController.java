package com.revature.controllers;

// controller layer is where HTTP requests get sent after javalin directs them
// its in this layer that we'll parse any JSON into Java objects and vice versa
// well either be getting data from the service layer (which gets the data from the DAO)
// OR well be sending data that came from the webpage to the service layer (which sends the data to the DAO)

import com.google.gson.Gson;
import com.revature.models.User;
import com.revature.services.UserService;
import io.javalin.http.Handler;
import org.eclipse.jetty.server.Authentication;

import java.util.ArrayList;

public class UserController {

    // we need a UserService object
    UserService us = new UserService();

    // this handler will get the HTTP GET request for all users, and send back the users from database
    public Handler getUsersHandler = (ctx) -> {
        if (ctx.req.getSession(true) != null) { //if the session exists
            ArrayList<User> users = us.getUsers();
            Gson gson = new Gson();
            String JSONUsers = gson.toJson(users);
            ctx.result(JSONUsers);
            ctx.status(200);
        } else { //if session doesnt exist (user isnt logged in)
            ctx.status(401);
        };
    };
}

