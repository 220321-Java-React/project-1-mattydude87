package com.revature;
import java.sql.Connection;
import java.sql.SQLException;

import com.revature.controllers.AuthController;
import com.revature.controllers.ReimbursementController;
import com.revature.controllers.UserController;
import com.revature.utils.ConnectionUtil;
import io.javalin.Javalin;
import io.javalin.core.JavalinConfig;

public class Launcher {

    public static void main(String[] args) {


        try(Connection conn = ConnectionUtil.getConnection()){
            System.out.println("CONNECTION SUCCESSFUL :)");
        } catch (SQLException e) {
            System.out.println("connection failed... :(");
            e.printStackTrace();
        }

        //instantiating an UserController object so that we can access its Handlers
        UserController uc = new UserController();
        //instantiating an AuthController object so we can access its handler
        AuthController ac = new AuthController();
        ReimbursementController rc = new ReimbursementController();

        // typical javalin syntax to create a javalin object
        //allows us to process JS requests from anywhere
        Javalin app = Javalin.create(
                //the config lambda lets us specify certain configurations
                JavalinConfig::enableCorsForAllOrigins
        ).start(5000);
        // takes in a url endpoint, and a place in the server to send the request to
        app.get("/users", uc.getUsersHandler);
        app.get("/reimbursements", rc.getReimbursementsHandler);
        app.get("/reimbursement/requests", rc.getReimbursementRequestsHandler);
        app.post("/login", ac.loginHandler);

    }
}
