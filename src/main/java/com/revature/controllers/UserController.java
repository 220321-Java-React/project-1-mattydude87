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
    UserService es = new UserService();

    // this handler will get the HTTP GET request for all users, and send back the users from database
    public Handler getUsersHandler = (ctx) -> {

        ArrayList<User> users = es.getUsers();

        // create a gson object to convert our java object into JSON (since we can only transfer JSON, not java)
        Gson gson = new Gson();

        // using the gson.tojson () method to turn our java into JSON
        String JSONUsers = gson.toJson(users);

        ctx.result(JSONUsers);
        ctx.status(200);
    };
}
