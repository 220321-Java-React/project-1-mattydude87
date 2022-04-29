package com.revature;
import java.sql.Connection;
import java.sql.SQLException;

import com.revature.controllers.UserController;
import com.revature.utils.ConnectionUtil;
import io.javalin.Javalin;

public class Launcher {

    public static void main(String[] args) {


        try(Connection conn = ConnectionUtil.getConnection()){
            System.out.println("CONNECTION SUCCESSFUL :)");
        } catch (SQLException e) {
            System.out.println("connection failed... :(");
            e.printStackTrace();
        }

        //instantiating an EmployeeController object so that we can access its Handlers
        UserController uc = new UserController();

        // typical javalin syntax to create a javalin object
        Javalin app = Javalin.create(
                //the config lambda lets us specify certain configurations
                config -> {
                    config.enableCorsForAllOrigins(); //allows us to process JS requests from anywhere
                }
        ).start(3000);
        // takes in a url endpoint, and a place in the server to send the request to
        app.get("/users", uc.getUsersHandler);

    }
}
