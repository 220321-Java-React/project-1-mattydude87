package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.models.LoginDTO;
import com.revature.services.AuthService;
import io.javalin.http.Handler;

//we need an authservice object to use its method


public class AuthController {
    AuthService as = new AuthService();

    //we need a loginhandler to handle login requests which come to app.post("/login", xxx)

    public Handler loginHandler = (ctx) -> {
        //with POST requests, we have data coming in, which we access with ctx.body();
        //data user sends in
        String body = ctx.body();
        //Gson object to make Java
        Gson gson = new Gson();
        //takes JSON and turns it into java object
        LoginDTO LDTO = gson.fromJson(body, LoginDTO.class);

        //control flow to determine what happens in the event of successful/unsuccessful login
        if(as.login(LDTO.getUsername(), LDTO.getPassword()) != null) {
            // if login is successful, create a user session so that they can access the applications
            // functionalities
            ctx.req.getSession();
            ctx.status(202); //202 stands for accepted
            //send back user object
            String userJSON = gson.toJson((as.login(LDTO.getUsername(), LDTO.getPassword())));

            //send back our user JSON object
            ctx.result(userJSON);

        } else {
            ctx.status(401); //401 stands for "unauthorized"
            System.out.println("login failed");

        }
    };

}

