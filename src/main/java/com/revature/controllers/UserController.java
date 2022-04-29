package com.revature.controllers;

// controller layer is where HTTP requests get sent after javalin directs them
// its in this layer that we'll parse any JSON into Java objects and vice versa
// well either be getting data from the service layer (which gets the data from the DAO)
// OR well be sending data that came from the webpage to the service layer (which sends the data to the DAO)

import com.google.gson.Gson;
import com.revature.models.User;
import com.revature.services.UserService;
import io.javalin.http.Handler;

import java.util.ArrayList;

public class UserController {

    // we need a userservice object
    UserService es = new UserService();

    public Handler getUsersHandler = (ctx) -> {

        ArrayList<User> users = es.getUsers();

        Gson gson = new Gson();

        String JSONUsers = gson.toJson(users);

        ctx.result(JSONUsers);
        ctx.status(200);
    };
}
